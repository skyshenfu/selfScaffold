package com.zty.scaffold.ui.tab1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zty.common.base.BaseVMFragment;
import com.zty.common.databinding.DataBindingBuilder;
import com.zty.common.observer.NetObserver;
import com.zty.pojo.PublicAccountBean;
import com.zty.scaffold.BR;
import com.zty.scaffold.R;

import java.util.List;

public class TabFragment1 extends BaseVMFragment {
    private Tab1ViewModel mViewModel;

    @Override
    protected void initViewModels() {

    }

    @Override
    protected void afterViewCreated(View view, Bundle savedInstanceState) {
        Log.e("TAG", "afterViewCreated: TabFragment1"+this.toString());
        mViewModel.getAccountLiveData().observe(getViewLifecycleOwner(), new NetObserver<List<PublicAccountBean>>() {
            @Override
            protected void successCallBack(List<PublicAccountBean> data) {
                Log.e("TAG", "successCallBack: " );
            }
        });
    }

    @Override
    public DataBindingBuilder getDataBindingBuilder() {
        mViewModel=getFragmentViewModel(Tab1ViewModel.class);
        return new DataBindingBuilder(R.layout.fragment_tab_1)
                .addBindingParam(BR.vm,mViewModel)
                .addBindingParam(BR.proxy,new Tab1ClickProxy());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    public  class  Tab1ClickProxy{
        public void clickCenter(){
            mViewModel.accountRequest();
        }
    }

}
