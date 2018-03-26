package com.simonov.testappbiapetr.ui;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.simonov.testappbiapetr.R;
import com.simonov.testappbiapetr.api.TerminalResponse;

public class PickActivity extends AppCompatActivity implements StartFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;
    ViewPagerAdapter mDemoCollectionPagerAdapter;
    ViewPager mViewPager;
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        mDemoCollectionPagerAdapter =
                new ViewPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);

        mActionBar = getSupportActionBar();

        // Specify that tabs should be displayed in the action bar.
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create a tab listener that is called when the user changes tabs.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // hide the given tab
            }

            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // probably ignore this event
            }
        };

        // Add 2 tabs, specifying the tab's text and TabListener
        String[] tabNames = {"Start", "Destination"};
        for (int i = 0; i < 2; i++) {
            mActionBar.addTab(
                    mActionBar.newTab()
                            .setText(tabNames[i])
                            .setTabListener(tabListener));
        }
    }

    @Override
    public void onFragmentInteraction(TerminalResponse terminalResponse) {
        Log.d("spree", "onFragmentInteraction");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ActionBar.Tab tab = mActionBar.getTabAt(position);
            tab.select();
            if (position == 0) {
                return new StartFragment();
            } else {
                return new DestinationFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
