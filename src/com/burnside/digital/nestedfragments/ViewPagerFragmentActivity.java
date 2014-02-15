package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.burnside.digital.nestedfragments.fragment.ParentViewPagerFragment;

public class ViewPagerFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.activity_viewpager_title);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(ParentViewPagerFragment.TAG);

        if (fragment == null) {
            fragment = ParentViewPagerFragment.newInstance();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(android.R.id.content, fragment, ParentViewPagerFragment.TAG);
            ft.commit();
        }
    }

}
