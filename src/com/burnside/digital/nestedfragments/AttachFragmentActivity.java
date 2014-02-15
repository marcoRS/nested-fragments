package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class AttachFragmentActivity extends FragmentActivity {

    public static final String FRAGMENT_TAG_KEY = "FragmentTagKey";
    public static final String ACTIVITY_TITLE_KEY = "ActivityTitleKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String tag = extras.getString(FRAGMENT_TAG_KEY);
        String title = getString(extras.getInt(ACTIVITY_TITLE_KEY));

        setTitle(title);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(tag);

        if (fragment == null) {
            fragment = Fragment.instantiate(this, tag);
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(android.R.id.content, fragment, tag);
            ft.commit();
        }
    }

}
