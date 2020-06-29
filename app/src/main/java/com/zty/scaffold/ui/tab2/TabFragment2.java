package com.zty.scaffold.ui.tab2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zty.common.base.BaseVMFragment;
import com.zty.common.databinding.DataBindingBuilder;
import com.zty.scaffold.BR;
import com.zty.scaffold.R;

public class TabFragment2 extends BaseVMFragment {
    @Override
    protected void initViewModels() {

    }

    @Override
    protected void afterViewCreated(View view, Bundle savedInstanceState) {
        Log.e("TAG", "afterViewCreated: TabFragment2"+this.toString());

    }

    @Override
    public DataBindingBuilder getDataBindingBuilder() {
        return new DataBindingBuilder(R.layout.fragment_tab_2).addBindingParam(BR.proxy,new Tab2ClickProxy());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
   public  class  Tab2ClickProxy{
        public void clickCenter(){
            nav().navigate(R.id.action_fragment_host_to_fragment_second);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
