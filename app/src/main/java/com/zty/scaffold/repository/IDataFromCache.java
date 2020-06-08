package com.zty.scaffold.repository;

import androidx.lifecycle.MutableLiveData;

import com.zty.http.ResponseRawBean;
import com.zty.pojo.PublicAccountBean;

import java.util.List;

public interface IDataFromCache extends IDataFrom{
    void cacheLoadAccount(MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> targetLiveData);
}
