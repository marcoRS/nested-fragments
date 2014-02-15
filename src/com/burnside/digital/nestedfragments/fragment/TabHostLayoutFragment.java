package com.burnside.digital.nestedfragments.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.burnside.digital.nestedfragments.R;

public class TabHostLayoutFragment extends Fragment {

    public static final String TAG = TabHostLayoutFragment.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tab_host_layout, container, false);

        FragmentTabHost tabHost = (FragmentTabHost) root.findViewById(android.R.id.tabhost);
        /** Important: Must use child FragmentManager. */
        tabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        Bundle arg1 = new Bundle();
        arg1.putInt(ChildFragment.POSITION_KEY, 1);
        tabHost.addTab(tabHost.newTabSpec("ChildTag1").setIndicator("Child Fragment 1"),
                ChildFragment.class, arg1);

        Bundle arg2 = new Bundle();
        arg2.putInt(ChildFragment.POSITION_KEY, 2);
        tabHost.addTab(tabHost.newTabSpec("ChildTag2").setIndicator("Child Fragment 2"),
                ChildFragment.class, arg2);

        return root;
    }
}
