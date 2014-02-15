package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import com.burnside.digital.nestedfragments.fragment.ParentViewPagerFragment;
import com.burnside.digital.nestedfragments.fragment.SingleChildFragment;

public class TabHostFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.activity_tabhost_title);

        FragmentTabHost tabHost = new FragmentTabHost(this);
        setContentView(tabHost);

        tabHost.setup(this, getSupportFragmentManager(), R.layout.activity_nest_list);

        tabHost.addTab(tabHost.newTabSpec("ParentViewPagerFragment").setIndicator("View Pager"),
                ParentViewPagerFragment.class, null);

        tabHost.addTab(tabHost.newTabSpec("SingleFragment").setIndicator("Single Fragment"),
                SingleChildFragment.class, null);
    }

}
