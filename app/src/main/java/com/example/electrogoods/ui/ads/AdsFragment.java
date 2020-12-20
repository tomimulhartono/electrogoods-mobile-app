package com.example.electrogoods.ui.ads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.electrogoods.R;
import com.example.electrogoods.Tab1FragmentAds;
import com.example.electrogoods.Tab2FragmentAds;
import com.google.android.material.tabs.TabLayout;

public class AdsFragment extends Fragment {

    private final static String TAG = "AdsFragment";
    private SectionPageAdapterAds mSectionPageAdapter;
    private ViewPager mViewPager;
    private AdsViewModel adsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ads, container, false);
        mSectionPageAdapter = new SectionPageAdapterAds(getChildFragmentManager(),1);

        mViewPager = root.findViewById(R.id.container_ads);
        setupViewPager(mViewPager);

        TabLayout tabLayout = root.findViewById(R.id.tabs_ads);
        tabLayout.setupWithViewPager(mViewPager);
        return root;
    }

    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapterAds adapter = new SectionPageAdapterAds(getChildFragmentManager(),1);
        adapter.addFragment(new Tab1FragmentAds(), "ADS");
        adapter.addFragment(new Tab2FragmentAds(), "FAVOURITES");
        viewPager.setAdapter(adapter);
    }
}
