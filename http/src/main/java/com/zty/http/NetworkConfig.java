package com.zty.http;

public class NetworkConfig {
    //网络超时时间:读超时
    public static final int NET_READ_TIME_OUT=10000;
    //网络超时时间:写超时
    public static final int NET_WRITE_TIME_OUT=10000;
    //网络超时时间:连接超时
    public static final int NET_CONNECT_TIME_OUT=10000;

    //header的Holder，这里给Header提供一个默认的占位符，用于替换URL


    public static final String BASE_URL="https://wanandroid.com";

}
