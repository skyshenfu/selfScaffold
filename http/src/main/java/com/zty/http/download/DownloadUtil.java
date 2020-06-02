package com.zty.http.download;

import androidx.annotation.NonNull;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executors;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DownloadUtil {
    public static final int THREAD_POOL_SIZE=5;
    private Retrofit mRetrofit;
    private DownloadService mDownloadService;

    private DownloadUtil(){
        mRetrofit = new Retrofit.Builder()
                //这个URl无所谓 因为会被覆盖掉
                .baseUrl("http://www.xxx.com")
                //通过线程池获取一个线程，指定callback在子线程中运行。
                .callbackExecutor(Executors.newFixedThreadPool(THREAD_POOL_SIZE))
                .build();

        mDownloadService = mRetrofit.create(DownloadService.class);
    }
    private static  class  DownloadUtilHolder{
        private  static DownloadUtil downloadUtil=new DownloadUtil();
    }
    public static DownloadUtil getInstance(){
        return   DownloadUtilHolder.downloadUtil;
    }


    public Call<ResponseBody> download(String url, final String path, final DownloadListener downloadListener) {

        Call<ResponseBody> call = mDownloadService.download(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull final Response<ResponseBody> response) {
                //将Response写入到从磁盘中，详见下面分析
                //注意，这个方法是运行在子线程中的
                writeResponseToDisk(path, response, downloadListener);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable throwable) {
                downloadListener.onFail("网络错误～");
            }
        });
        return call;
    }

    private static void writeResponseToDisk(String path, Response<ResponseBody> response, DownloadListener downloadListener) {
        //从response获取输入流以及总大小
        writeFileFromIS(new File(path), response.body().byteStream(), response.body().contentLength(), downloadListener);
    }

    private static int sBufferSize = 8192;

    //将输入流写入文件
    private static void writeFileFromIS(File file, InputStream is, long totalLength, DownloadListener downloadListener) {
        //开始下载
        downloadListener.onStart();

        //创建文件
        if (!file.exists()) {
            if (!file.getParentFile().exists())
                file.getParentFile().mkdir();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                downloadListener.onFail("createNewFile IOException");
            }
        }

        OutputStream os = null;
        long currentLength = 0;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            byte data[] = new byte[sBufferSize];
            int len;
            int lastProgress=0;
            while ((len = is.read(data, 0, sBufferSize)) != -1) {
                os.write(data, 0, len);
                currentLength += len;
                //计算当前下载进度
                int current=(int) (100 * currentLength / totalLength);
                //防止重复走回调
                if (current>lastProgress){
                    lastProgress=current;
                    downloadListener.onProgress(current);
                }
            }
            //下载完成，并返回保存的文件路径
            downloadListener.onFinish(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            downloadListener.onFail("IOException");
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
