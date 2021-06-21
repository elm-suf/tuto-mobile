package com.elmsuf.tuto_final.view.home;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.elmsuf.tuto_final.R;
import com.elmsuf.tuto_final.databinding.ActivityMainBinding;
import com.elmsuf.tuto_final.view.account.AccountFragment;
import com.elmsuf.tuto_final.view.reservations.ReservationsFragment;
import com.elmsuf.tuto_final.view.search.SearchFragment;

public class MainActivity extends AppCompatActivity implements SearchFragment.OnFragmentInteractionListener, ReservationsFragment.OnFragmentInteractionListener, AccountFragment.OnFragmentInteractionListener {
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        tabLayout = binding.tabLayout;
        tabLayout.addTab(tabLayout.newTab().setText("Search").setIcon(R.drawable.tabsearch));
        tabLayout.addTab(tabLayout.newTab().setText("reservations").setIcon(R.drawable.schedule));
        tabLayout.addTab(tabLayout.newTab().setText("Account").setIcon(R.drawable.tabuser));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = binding.viewPager;
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}