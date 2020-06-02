package com.zty.http.service;

import androidx.lifecycle.MutableLiveData;
import com.zty.pojo.PublicAccountBean;
import com.zty.http.ResponseRawBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WanService {


    @GET("wxarticle/chapters/json")
    MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> getLiveDataPublicAccount();

    @GET("wxarticle/chapters/json")
    Call<ResponseRawBean<List<PublicAccountBean>>> getCallPublicAccount();
}

