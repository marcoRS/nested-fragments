package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.burnside.digital.nestedfragments.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	if (getSupportFragmentManager().findFragmentByTag(ParentFragment.TAG) == null) {
	    getSupportFragmentManager().beginTransaction()
		    .add(android.R.id.content, ParentFragment.newInstance(), ParentFragment.TAG).commit();
	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.activity_main, menu);
	return true;
    }

}
