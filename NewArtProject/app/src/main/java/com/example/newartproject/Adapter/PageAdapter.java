package com.example.newartproject.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.newartproject.Fragments.Tab1Fragment;
import com.example.newartproject.Fragments.Tab2Fragment;
import com.example.newartproject.Fragments.Tab3Fragment;
import com.example.newartproject.Fragments.Tab4Fragment;

public class PageAdapter extends FragmentStatePagerAdapter {
    int _numOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this._numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return  Tab1Fragment.getInstance();
            case 1: return  Tab2Fragment.getInstance();
            case 2: return  Tab3Fragment.getInstance();
            case 3: return  Tab4Fragment.getInstance();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return _numOfTabs;
    }
}
