package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import com.burnside.digital.nestedfragments.fragment.ParentTabHostFragment;
import com.burnside.digital.nestedfragments.fragment.ParentViewPagerFragment;
import com.burnside.digital.nestedfragments.fragment.SingleChildFragment;

public class TabHostFragmentActivity extends FragmentActivity {

    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.activity_tabhost_title);

        tabHost = new FragmentTabHost(this);
        setContentView(tabHost);

        tabHost.setup(this, getSupportFragmentManager(), R.layout.activity_main);

        tabHost.addTab(tabHost.newTabSpec("ParentViewPagerFragment").setIndicator("View Pager"),
                ParentViewPagerFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("SingleFragment").setIndicator("Single Fragment"),
                SingleChildFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("EmbeddedTabHost").setIndicator("Embedded TabHost"),
                ParentTabHostFragment.class, null);
    }

}
