package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabHostParentFragment extends Fragment {
    private FragmentTabHost mTabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	mTabHost = new FragmentTabHost(getActivity());
	mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_tabhost);

	Bundle arg1 = new Bundle();
	arg1.putInt(TextViewFragment.POSITION_KEY, 1);
	mTabHost.addTab(mTabHost.newTabSpec("TabHostTextView1").setIndicator("Child 1"),
		TextViewFragment.class, arg1);

	Bundle arg2 = new Bundle();
	arg2.putInt(TextViewFragment.POSITION_KEY, 2);
	mTabHost.addTab(mTabHost.newTabSpec("TabHostTextView2").setIndicator("Child 2"),
		TextViewFragment.class, arg2);

	return mTabHost;
    }

    @Override
    public void onDestroyView() {
	super.onDestroyView();
	mTabHost = null;
    }
}
