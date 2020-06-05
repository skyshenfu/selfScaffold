package com.zty.common.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.zty.common.global.GlobalViewModel;

public class BaseActivity extends AppCompatActivity{
    //Activity内ViewModel的供给器
    private ViewModelProvider mActivityProvider;

    private GlobalViewModel mGlobalViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGlobalViewModel=getActivityViewModel(GlobalViewModel.class);
    }

    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(this);
        }
        return mActivityProvider.get(modelClass);
    }

    public GlobalViewModel getGlobalViewModel() {
        return mGlobalViewModel;
    }
}
