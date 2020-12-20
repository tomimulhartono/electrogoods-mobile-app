package com.example.electrogoods.ui.chat;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPageAdapterChat extends FragmentPagerAdapter {

    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public SectionPageAdapterChat(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
//    private final Context mContext;

    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
