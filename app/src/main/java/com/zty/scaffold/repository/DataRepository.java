package com.zty.scaffold.repository;

import androidx.lifecycle.MutableLiveData;

import com.zty.http.ResponseRawBean;
import com.zty.http.callback.CommonCallBack;
import com.zty.http.service.WanAPI;
import com.zty.pojo.PublicAccountBean;

import java.util.List;

import retrofit2.Call;


public class DataRepository implements IDataFromRemote,IDataFromCache{
    /**
     * 静态内部类，实现单例
     */
    private static class SingletonHolder {
        private static DataRepository instance = new DataRepository();
    }

    //获取单例
    public static DataRepository getInstance() {
        return SingletonHolder.instance;
    }
    //私有化构造器
    private DataRepository(){

    }

    @Override
    public void cacheLoadAccount(MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> targetLiveData) {

    }

    @Override
    public void remoteLoadAccount(MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> targetLiveData) {
        Call<ResponseRawBean<List<PublicAccountBean>>> call=WanAPI.getInstance().getLPublicAccount();
        call.enqueue(new CommonCallBack<>(targetLiveData));
    }
}
