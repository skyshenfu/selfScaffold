package com.zty.scaffold.ui.host;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.zty.scaffold.ui.tab1.TabFragment1;
import com.zty.scaffold.ui.tab2.TabFragment2;
import com.zty.scaffold.ui.tab3.TabFragment3;


public final class HostFragmentAdapter extends FragmentStateAdapter {

    public HostFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new TabFragment1();

        }else if (position==1){
            return new TabFragment2();

        }else if (position==2){
            return new TabFragment3();

        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}