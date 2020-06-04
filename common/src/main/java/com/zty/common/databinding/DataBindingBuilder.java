package com.zty.common.databinding;

import android.util.SparseArray;

import androidx.annotation.LayoutRes;
import androidx.lifecycle.ViewModel;

public class DataBindingBuilder {

    private SparseArray<Object> bindingParams;
    //本界面相关ViewModel
    private ViewModel mViewModel;
    //本界面相关布局的资源id
    @LayoutRes
    private int mLayoutID;

    public  DataBindingBuilder(@LayoutRes int layoutID, ViewModel viewModel){
        this.bindingParams = new SparseArray<>();
        this.mLayoutID=layoutID;
        this.mViewModel=viewModel;

    }
    public DataBindingBuilder addBindingParam(int brID, Object object) {
        if (bindingParams.get(brID) == null) {
            bindingParams.put(brID, object);
        }
        return this;
    }

    public SparseArray<Object> getBindingParams() {
        return bindingParams;
    }

    public ViewModel getViewModel() {
        return mViewModel;
    }

    public int getLayoutID() {
        return mLayoutID;
    }
}
