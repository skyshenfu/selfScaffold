/**
  * Copyright 2019 bejson.com 
  */
package com.zty.http;

import com.zty.http.exception.NetBusinessException;

import java.io.Serializable;

/**
 * Auto-generated: 2019-10-30 11:22:27
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ResponseRawBean<T> implements Serializable {

    private T data;
    private int errorCode;
    private String errorMsg;
    private Throwable throwable;

    public ResponseRawBean(Throwable throwable) {
        this.throwable = throwable;
        this.errorMsg=throwable.getMessage();
    }

    public ResponseRawBean() {
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public ResponseRawBean(T data) {
        this.data = data;
    }


    public ResponseRawBean(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.throwable=new NetBusinessException();
    }

    public void setErrorCode(int errorCode) {
         this.errorCode = errorCode;
     }
     public int getErrorCode() {
         return errorCode;
     }

    public void setErrorMsg(String errorMsg) {
         this.errorMsg = errorMsg;
     }
     public String getErrorMsg() {
         return errorMsg;
     }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}