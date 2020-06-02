package com.zty.http.exception;

import com.zty.pojo.NetBusinessErrorBean;

import java.io.IOException;

public class NetBusinessException extends IOException {
    private NetBusinessErrorBean netBusinessErrorBean;
    public NetBusinessException() {
    }

    public NetBusinessException(NetBusinessErrorBean  netBusinessErrorBean) {
        super(netBusinessErrorBean.getErrorMessage());
        this.netBusinessErrorBean=netBusinessErrorBean;
    }

    public NetBusinessException(String message) {
        super(message);
    }

    public NetBusinessErrorBean getNetBusinessErrorBean() {
        return netBusinessErrorBean;
    }
}
