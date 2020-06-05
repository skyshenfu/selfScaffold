package com.zty.scaffold.ui.tab1;

import android.view.View;

import com.zty.common.base.BaseVMFragment;
import com.zty.common.databinding.DataBindingBuilder;
import com.zty.scaffold.R;

public class TabFragment1 extends BaseVMFragment {
    @Override
    protected void initViewModels() {

    }

    @Override
    protected void afterViewCreated(View view) {

    }

    @Override
    public DataBindingBuilder getDataBindingBuilder() {
        return new DataBindingBuilder(R.layout.fragment_tab_1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
