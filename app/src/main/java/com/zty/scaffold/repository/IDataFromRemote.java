package com.zty.scaffold.repository;

import androidx.lifecycle.MutableLiveData;

import com.zty.http.ResponseRawBean;
import com.zty.pojo.PublicAccountBean;

import java.util.List;

public interface IDataFromRemote extends IDataFrom{
    void remoteLoadAccount(MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> targetLiveData);
}
