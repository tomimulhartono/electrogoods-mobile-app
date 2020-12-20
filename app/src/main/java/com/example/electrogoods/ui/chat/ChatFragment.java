package com.example.electrogoods.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.electrogoods.R;
import com.example.electrogoods.Tab1FragmentChat;
import com.example.electrogoods.Tab2FragmentChat;
import com.example.electrogoods.Tab3FragmentChat;
import com.google.android.material.tabs.TabLayout;

public class ChatFragment extends Fragment {

    private final static String TAG = "ChatFragment";
    private SectionPageAdapterChat mSectionPageAdapter;
    private ViewPager mViewPager;
    private ChatViewModel chatViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        chatViewModel =
                ViewModelProviders.of(this).get(ChatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chat, container, false);
        mSectionPageAdapter = new SectionPageAdapterChat(getChildFragmentManager(),1);

        mViewPager = root.findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return root;
    }

    private void setupViewPager(ViewPager viewPager){
        SectionPageAdapterChat adapter = new SectionPageAdapterChat(getChildFragmentManager(),1);
        adapter.addFragment(new Tab1FragmentChat(), "ALL");
        adapter.addFragment(new Tab2FragmentChat(), "BUYING");
        adapter.addFragment(new Tab3FragmentChat(), "SELLING");
        viewPager.setAdapter(adapter);
    }
}
