package com.burnside.digital.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.burnside.digital.nestedfragments.R;

public class ParentFragment extends Fragment {

    public static final String TAG = ParentFragment.class.getSimpleName();

    public static ParentFragment newInstance() {
	return new ParentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	return inflater.inflate(R.layout.fragment_parent, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
	super.onViewCreated(view, savedInstanceState);

	ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
	mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
    }

    public static class MyAdapter extends FragmentPagerAdapter {
	public MyAdapter(FragmentManager fm) {
	    super(fm);
	}

	@Override
	public int getCount() {
	    return 4;
	}

	@Override
	public Fragment getItem(int position) {
	    Bundle args = new Bundle();
	    args.putInt(TextViewFragment.POSITION_KEY, position);
	    return TextViewFragment.newInstance(args);
	}

	@Override
	public CharSequence getPageTitle(int position) {
	    return "Fragment # " + position;
	}

    }

}
