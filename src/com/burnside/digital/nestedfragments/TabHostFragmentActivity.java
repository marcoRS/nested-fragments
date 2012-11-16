package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;

public class TabHostFragmentActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setTitle("TabHost Fragment Activity");
	mTabHost = new FragmentTabHost(this);
	setContentView(mTabHost);

	mTabHost.setup(this, getSupportFragmentManager(), R.layout.activity_main);
	mTabHost.addTab(mTabHost.newTabSpec("ParentViewPagerFragment").setIndicator("View Pager"),
		ParentFragment.class, null);
	mTabHost.addTab(mTabHost.newTabSpec("SingleFragment").setIndicator("Single Fragment"),
		TextViewFragment.class, null);

	mTabHost.addTab(mTabHost.newTabSpec("EmbeddedTabHost").setIndicator("Embedded TabHost"),
		TabHostParentFragment.class, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.activity_tab_host_fragment, menu);
	return true;
    }

}
