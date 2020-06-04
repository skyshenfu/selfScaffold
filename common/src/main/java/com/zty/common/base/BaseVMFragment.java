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
    private ViewDataBinding mBinding;

    //此方法在切勿在onCreateView之前使用
    public ViewDataBinding getViewDataBinding() {
        return mBinding;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DataBindingBuilder dataBindingBuilder = getDataBindingBuilder();
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, dataBindingBuilder.getLayoutID(), container, false);
        binding.setLifecycleOwner(this);
        mBinding = binding;
        return mBinding.getRoot();
    }
   protected abstract DataBindingBuilder getDataBindingBuilder();

    protected abstract void  initViewModels();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModels();
        setDataForDataBinding();
        afterViewCreated();
    }

    protected abstract void afterViewCreated();

    private void setDataForDataBinding() {
        SparseArray<Object> bindingParams = getDataBindingBuilder().getBindingParams();
        for (int i = 0, length = bindingParams.size(); i < length; i++) {
            mBinding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
    }
}
