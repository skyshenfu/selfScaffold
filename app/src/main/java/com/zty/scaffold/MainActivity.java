package com.zty.scaffold;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.zty.common.base.BaseVMActivity;
import com.zty.common.databinding.DataBindingBuilder;


public class MainActivity extends BaseVMActivity {

    private NavController navController;

    @Override
    protected void afterOnCreate(View root) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.demo_host_fragment);
        navController= NavHostFragment.findNavController(fragment);
    }

    @Override
    protected void initViewModels() {
    }

    @Override
    public DataBindingBuilder getDataBindingBuilder() {
        return new DataBindingBuilder(R.layout.activity_main)
                .addBindingParam(BR.switch1,true)
                .addBindingParam(BR.textContent,"这里设置");
    }
}