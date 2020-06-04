package com.zty.common.observer;


import android.accounts.NetworkErrorException;

import androidx.lifecycle.Observer;

import com.zty.http.ResponseRawBean;
import com.zty.http.exception.NetBusinessException;
import com.zty.pojo.NetBusinessErrorBean;

public abstract class NetObserver <T> implements Observer<ResponseRawBean<T>> {

    @Override
    public void onChanged(ResponseRawBean<T> tResponseRawBean) {
        //有返回值的情况
        if (tResponseRawBean!=null){

            if (tResponseRawBean.getErrorCode()==0){
               if (tResponseRawBean.getData()!=null&&tResponseRawBean.getThrowable()==null){
                   //业务上没有错误，且不存在异常视为正常返回
                   successCallBack(tResponseRawBean.getData());
               }else {
                   //属于网络层出的问题
                   errorCallback(tResponseRawBean.getThrowable());
               }
            }else {
                //属于业务层出的问题
                errorCallback(new NetBusinessException(new NetBusinessErrorBean(tResponseRawBean.getErrorCode(),tResponseRawBean.getErrorMsg())));
            }
            finalCallback();
        }



    }
    //正确时回调
    protected abstract void successCallBack(T data);
    //错误时回调
    protected void errorCallback(Throwable throwable){
    }
    //无论正确错误都会走的回调
    protected void finalCallback(){

    }
}
