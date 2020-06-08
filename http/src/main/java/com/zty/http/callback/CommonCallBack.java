package com.zty.http.callback;

import androidx.lifecycle.MutableLiveData;

import com.zty.http.ResponseRawBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 这个类是为了避免重复重复代码编写的通用Callback
 * @param <V> CallBack返回的类型
 */
public class CommonCallBack<V> implements Callback<ResponseRawBean<V>> {
    private MutableLiveData<ResponseRawBean<V>> mLiveData;

    public CommonCallBack(MutableLiveData<ResponseRawBean<V>> liveData) {
        this.mLiveData = liveData;
    }

    @Override
    public void onResponse(Call<ResponseRawBean<V>> call, Response<ResponseRawBean<V>> response) {
        if (mLiveData != null && mLiveData.hasObservers())
            mLiveData.postValue(response.body());
    }

    @Override
    public void onFailure(Call<ResponseRawBean<V>> call, Throwable t) {
        if (mLiveData != null && mLiveData.hasObservers())
            mLiveData.postValue(new ResponseRawBean<>(t));

    }
}
