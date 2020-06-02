package com.zty.http.download;

public  interface DownloadListener {
    void onStart();
    void onProgress(int progress);
    void onFinish(String path);
    void onFail(String errorInfo);


}
