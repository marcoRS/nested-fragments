package com.burnside.digital.nestedfragments.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.burnside.digital.nestedfragments.R;

/**
 * The child fragment is no different than any other fragment other than it is now being maintained by
 * a child FragmentManager.
 */
public class ChildFragment extends Fragment implements OnClickListener {

    public static final String POSITION_KEY = "FragmentPositionKey";
    private int position;

    public static ChildFragment newInstance(Bundle args) {
        ChildFragment fragment = new ChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        position = getArguments().getInt(POSITION_KEY);

        View root = inflater.inflate(R.layout.fragment_child, container, false);
        TextView textview = (TextView) root.findViewById(R.id.textViewPosition);
        textview.setText(Integer.toString(position));
        textview.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "Clicked Position: " + position, Toast.LENGTH_LONG).show();
    }
}
