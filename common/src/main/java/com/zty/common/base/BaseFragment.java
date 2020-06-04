package com.zty.common.base;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class BaseFragment extends Fragment {

    protected BaseActivity mActivity;
    //Fragment内ViewModel的供给器
    private ViewModelProvider mFragmentProvider;
    //Ac内ViewModel的供给器
    private ViewModelProvider mActivityProvider;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mActivity= (BaseActivity) context;
    }
    //虽然此方法已废弃但经过验证 某些Android 6.0以下的手机会进行调用
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.mActivity= (BaseActivity) activity;

    }

    protected <T extends ViewModel> T getFragmentViewModel(@NonNull Class<T> modelClass) {
        if (mFragmentProvider == null) {
            mFragmentProvider = new ViewModelProvider(this);
        }
        return mFragmentProvider.get(modelClass);
    }

    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(mActivity);
        }
        return mActivityProvider.get(modelClass);
    }
}
