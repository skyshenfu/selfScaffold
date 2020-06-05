package com.zty.scaffold.ui.host;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zty.common.base.BaseVMFragment;
import com.zty.common.databinding.DataBindingBuilder;
import com.zty.scaffold.R;

public class HostFragment extends BaseVMFragment {
    BottomNavigationView bottomNavigationView;
    ViewPager2 mViewPager;
    HostFragmentAdapter hostFragmentAdapter;

    @Override
    protected void initViewModels() {

    }

    @Override
    protected void afterViewCreated(View view) {
        mViewPager=view.findViewById(R.id.viewpager);
        bottomNavigationView=view.findViewById(R.id.bottom_navigation);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuId=item.getItemId();
                switch (menuId){
                    case  R.id.item_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case  R.id.item_res:
                        mViewPager.setCurrentItem(1);
                        break;
                    case  R.id.item_my:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
        hostFragmentAdapter = new HostFragmentAdapter(getChildFragmentManager(),getLifecycle());
        mViewPager.setAdapter(hostFragmentAdapter);

        //取消拉边效果
        try {
            mViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        } catch (Exception ignored) {

        }

    }

    @Override
    public DataBindingBuilder getDataBindingBuilder() {
        return new DataBindingBuilder(R.layout.fragment_host);
    }
}
