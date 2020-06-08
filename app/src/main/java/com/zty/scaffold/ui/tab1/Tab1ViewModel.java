package com.zty.scaffold.ui.tab1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zty.common.base.BaseViewModel;
import com.zty.http.ResponseRawBean;
import com.zty.pojo.PublicAccountBean;
import com.zty.scaffold.repository.DataRepository;

import java.util.List;

public class Tab1ViewModel extends BaseViewModel {
    private MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> mAccountLiveData;

    public Tab1ViewModel() {
        mAccountLiveData=new MutableLiveData<>();

    }

    public LiveData<ResponseRawBean<List<PublicAccountBean>>> getAccountLiveData() {

        return mAccountLiveData;
    }

    public void  accountRequest(){
        DataRepository.getInstance().remoteLoadAccount(mAccountLiveData);
    }
}