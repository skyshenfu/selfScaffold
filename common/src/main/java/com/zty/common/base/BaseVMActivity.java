package com.zty.common.base;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.zty.common.databinding.DataBindingBuilder;

public abstract class BaseVMActivity extends BaseActivity implements SelfBinding {
    //ViewBinding对象
    protected ViewDataBinding mBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModels();
        setDataForDataBinding();
        afterOnCreate(mBinding.getRoot());

    }

    protected abstract void afterOnCreate(View root);

    protected abstract void initViewModels();

    private void setDataForDataBinding() {
        DataBindingBuilder mDataBindingBuilder = getDataBindingBuilder();
        mBinding= DataBindingUtil.setContentView(this, mDataBindingBuilder.getLayoutID());
        mBinding.setLifecycleOwner(this);
        SparseArray<Object> bindingParams = mDataBindingBuilder.getBindingParams();
        for (int i = 0, length = bindingParams.size(); i < length; i++) {
            mBinding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
    }
}
