package com.zty.scaffold.ui.tab3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zty.common.base.BaseVMFragment;
import com.zty.common.databinding.DataBindingBuilder;
import com.zty.scaffold.R;

public class TabFragment3 extends BaseVMFragment {
    @Override
    protected void initViewModels() {

    }

    @Override
    protected void afterViewCreated(View view, Bundle savedInstanceState) {
        Log.e("TAG", "afterViewCreated: TabFragment3"+this.toString());

    }

    @Override
    public DataBindingBuilder getDataBindingBuilder() {
        return new DataBindingBuilder(R.layout.fragment_tab_3);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
