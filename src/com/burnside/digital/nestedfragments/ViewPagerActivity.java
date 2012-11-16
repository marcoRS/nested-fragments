package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class ViewPagerActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setTitle("ViewPager Fragment Activity");

	if (getSupportFragmentManager().findFragmentByTag(ParentFragment.TAG) == null) {
	    getSupportFragmentManager().beginTransaction()
		    .add(android.R.id.content, ParentFragment.newInstance(), ParentFragment.TAG).commit();
	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.activity_view_pager, menu);
	return true;
    }

}
