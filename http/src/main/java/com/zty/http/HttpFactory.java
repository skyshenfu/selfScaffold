package com.zty.http;

import com.zty.http.converter.gson.GsonConverterFactory;
import com.zty.http.converter.livedata.LiveDataCallFactory;
import com.zty.http.converter.scalar.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class HttpFactory {
    private Retrofit mRetrofit;
    private OkHttpClient.Builder builder;

    private static class  HttpFactoryHolder{
        private static HttpFactory instance= new HttpFactory();
    }
    private HttpFactory(){
        builder=new OkHttpClient.Builder();
        // 设置超时
        builder.retryOnConnectionFailure(false)
                .connectTimeout(NetworkConfig.NET_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(NetworkConfig.NET_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(NetworkConfig.NET_WRITE_TIME_OUT, TimeUnit.SECONDS);

        OkHttpClient client = builder.build();
        mRetrofit = new Retrofit.Builder()
                // 设置请求的域名，这个是初始的baseUrl
                .baseUrl(NetworkConfig.BASE_URL)
                // 设置解析转换工厂，用自己定义的
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallFactory())
                .client(client)
                .build();
        ;
    }
    public <T>  T  crateService(Class<T> targetAPI){
        return mRetrofit.create(targetAPI);
    }

    public  static HttpFactory getInstance(){
        return HttpFactoryHolder.instance;
    }
}
