package com.msg.msgalaxy.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.msg.msgalaxy.MVCOfTopRated.ViewPagerAdapter;
import com.msg.msgalaxy.R;

public class TopRatedFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Clear the Transparent of status bar
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        view = inflater.inflate(R.layout.toprated_fragment , container , false);

        //Initialize The variables
        tabLayout = view.findViewById(R.id.topRatedFragment_tablayoutId);
        viewPager2 = view.findViewById(R.id.topRatedFragment_viewPagerId);

        setTabLayoutWithViewPager();

        return view;
    }

    private void setTabLayoutWithViewPager() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        viewPagerAdapter = new ViewPagerAdapter(fragmentManager , getActivity().getLifecycle());

        viewPager2.setAdapter(viewPagerAdapter);

        //Set the titles and the icons to the TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Movies"));
        tabLayout.getTabAt(0).setIcon(R.drawable.tablayout_movies_icon);
        tabLayout.addTab(tabLayout.newTab().setText("Series"));
        tabLayout.getTabAt(1).setIcon(R.drawable.tablayout_series_icon);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}
