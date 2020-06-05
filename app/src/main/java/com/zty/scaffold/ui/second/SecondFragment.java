package com.zty.scaffold.ui.second;

import android.view.View;

import com.zty.common.base.BaseVMFragment;
import com.zty.common.databinding.DataBindingBuilder;
import com.zty.scaffold.R;

public class SecondFragment extends BaseVMFragment {

    @Override
    protected void initViewModels() {

    }

    @Override
    protected void afterViewCreated(View view) {

    }

    @Override
    public DataBindingBuilder getDataBindingBuilder() {
        return new DataBindingBuilder(R.layout.fragment_second);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
