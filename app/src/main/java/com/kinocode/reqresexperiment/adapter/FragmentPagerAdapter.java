package com.kinocode.reqresexperiment.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kinocode.reqresexperiment.view.AddUserFragment;
import com.kinocode.reqresexperiment.view.ListResourceFragment;
import com.kinocode.reqresexperiment.view.ListUserFragment;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new ListUserFragment();
            case 1:
                return new ListResourceFragment();
            case 2:
                return new AddUserFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "List User";
            case 1:
                return "List Resource";
            case 2:
                return "Add User";

                default:
                    return null;
        }

    }
}
