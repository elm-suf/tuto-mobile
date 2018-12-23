package com.elmsuf.tuto_final.view.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.elmsuf.tuto_final.view.account.AccountFragment;
import com.elmsuf.tuto_final.view.reservations.ReservationsFragment;
import com.elmsuf.tuto_final.view.search.SearchFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int nOfTabs;

    public PagerAdapter(FragmentManager fm, int nOfTabs) {
        super(fm);
        this.nOfTabs = nOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new SearchFragment();
            case 1:
                return new ReservationsFragment();
            case 2:
                return new AccountFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nOfTabs;
    }
}
