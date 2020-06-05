package com.zty.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

public abstract class BaseVMActivity extends BaseActivity implements SelfBinding {
    //ViewBinding对象
    private ViewDataBinding mBinding;
    @Override
    public ViewDataBinding getViewDataBinding() {
        return mBinding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

}
