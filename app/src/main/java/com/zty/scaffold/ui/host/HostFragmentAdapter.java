package com.zty.scaffold.ui.host;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.zty.scaffold.ui.tab1.TabFragment1;
import com.zty.scaffold.ui.tab2.TabFragment2;
import com.zty.scaffold.ui.tab3.TabFragment3;

import java.util.HashMap;
import java.util.Map;


public final class HostFragmentAdapter extends FragmentStateAdapter {

    private  FragmentManager fragmentManager;

    public HostFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.fragmentManager=fragmentManager;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            Log.e("TAG", "createFragment1"+this.toString());
            for (Fragment fragment:fragmentManager.getFragments()){
                if (fragment instanceof TabFragment1){
                    return fragment;
                }
            }
            return new TabFragment1();

        }else if (position==1){
            Log.e("TAG", "createFragment2"+this.toString());
            for (Fragment fragment:fragmentManager.getFragments()){
                if (fragment instanceof TabFragment2){
                    return fragment;
                }
            }
            return new TabFragment2();

        }else if (position==2){
            Log.e("TAG", "createFragment3"+this.toString());
            for (Fragment fragment:fragmentManager.getFragments()){
                if (fragment instanceof TabFragment3){
                    return fragment;
                }
            }
            return new TabFragment3();

        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}