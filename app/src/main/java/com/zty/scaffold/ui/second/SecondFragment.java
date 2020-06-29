package com.zty.scaffold.ui.second;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;

import com.zty.common.base.BaseVMFragment;
import com.zty.common.databinding.DataBindingBuilder;
import com.zty.scaffold.R;

public class SecondFragment extends BaseVMFragment {

    @Override
    protected void initViewModels() {

    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

    }

    @Override
    protected void afterViewCreated(View view, Bundle savedInstanceState) {
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                nav().navigate(R.id.popup_second);
            }
        });
        Log.e("TAG", "afterViewCreated: SecondFragment"+this.toString());

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
