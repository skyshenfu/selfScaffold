package com.zty.http.service;

import androidx.lifecycle.MutableLiveData;

import com.zty.http.HttpFactory;
import com.zty.pojo.PublicAccountBean;
import com.zty.http.ResponseRawBean;

import java.util.List;

import retrofit2.Call;

public class WanAPI {

    private WanService wanService;
    private static  class  WanAPIHolder{
        private  static WanAPI wanAPI=new WanAPI();
    }
    public static WanAPI getInstance(){
      return   WanAPIHolder.wanAPI;
    }

    private WanAPI(){
        wanService = HttpFactory.getInstance().crateService(WanService.class);
    }


    public MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> getLiveDataPublicAccount(){
        return wanService.getLiveDataPublicAccount();
    }

    public Call<ResponseRawBean<List<PublicAccountBean>>> getLPublicAccount(){
        return wanService.getCallPublicAccount();
    }

}
