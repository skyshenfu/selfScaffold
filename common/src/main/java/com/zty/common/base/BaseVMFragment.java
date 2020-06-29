package com.zty.common.base;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;


import com.zty.common.databinding.DataBindingBuilder;

public abstract class BaseVMFragment extends BaseFragment implements SelfBinding{
    //ViewBinding对象
    protected ViewDataBinding mBinding;
    private DataBindingBuilder mDataBindingBuilder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initViewModels();
        mDataBindingBuilder = getDataBindingBuilder();
        mBinding= DataBindingUtil.inflate(inflater, mDataBindingBuilder.getLayoutID(), container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    protected abstract void  initViewModels();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDataForDataBinding();
        afterViewCreated(view,savedInstanceState);
    }

    protected abstract void afterViewCreated(View view, Bundle savedInstanceState);

    private void setDataForDataBinding() {
        SparseArray<Object> bindingParams = mDataBindingBuilder.getBindingParams();
        for (int i = 0, length = bindingParams.size(); i < length; i++) {
            mBinding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
    }

}
