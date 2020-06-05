package com.zty.scaffold;
import android.view.View;
import com.zty.common.base.BaseVMActivity;
import com.zty.common.databinding.DataBindingBuilder;


public class MainActivity extends BaseVMActivity {

    @Override
    protected void afterOnCreate(View root) {

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