package com.burnside.digital.nestedfragments.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.burnside.digital.nestedfragments.R;

public class ParentTabHostFragment extends Fragment {

    public static final String TAG = ParentTabHostFragment.class.getName();

    private FragmentTabHost fragmentTabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentTabHost = new FragmentTabHost(getActivity());

        /** Important: Must use Child FragmentManager */
        fragmentTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_parent_tab_host);

        Bundle arg1 = new Bundle();
        arg1.putInt(ChildFragment.POSITION_KEY, 1);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("ChildTag1").setIndicator("Child Fragment 1"),
                ChildFragment.class, arg1);

        Bundle arg2 = new Bundle();
        arg2.putInt(ChildFragment.POSITION_KEY, 2);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("ChildTag2").setIndicator("Child Fragment 2"),
                ChildFragment.class, arg2);

        return fragmentTabHost;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentTabHost = null;
    }
}
