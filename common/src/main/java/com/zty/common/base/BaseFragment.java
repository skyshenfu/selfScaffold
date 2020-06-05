package com.zty.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.zty.common.global.GlobalViewModel;

public class BaseFragment extends Fragment {

    protected BaseActivity mActivity;
    //Fragment内ViewModel的供给器
    private ViewModelProvider mFragmentProvider;
    //Activity内ViewModel的供给器
    private ViewModelProvider mActivityProvider;
    //全局级别的ViewModel的伴随App的生命周期
    private GlobalViewModel mGlobalViewModel;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGlobalViewModel = ((BaseApplication) mActivity.getApplicationContext()).getAppViewModelProvider(mActivity).get(GlobalViewModel.class);

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

    public GlobalViewModel getGlobalViewModel() {
        return mGlobalViewModel;
    }

    protected NavController nav() {
        return NavHostFragment.findNavController(this);
    }

}
