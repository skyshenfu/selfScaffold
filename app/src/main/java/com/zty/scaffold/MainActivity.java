package com.zty.scaffold;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.zty.common.base.NetObserver;
import com.zty.http.service.WanAPI;
import com.zty.pojo.PublicAccountBean;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WanAPI.getInstance().getLiveDataPublicAccount().observe(this,new NetObserver<List<PublicAccountBean>>(){
            @Override
            protected void successCallBack(List<PublicAccountBean> data) {
                Log.e("TAG", "successCallBack: " );
            }

            @Override
            protected void errorCallback(Throwable throwable) {
                super.errorCallback(throwable);
            }
        });
    }
}