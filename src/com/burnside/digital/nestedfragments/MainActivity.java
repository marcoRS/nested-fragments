package com.burnside.digital.nestedfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements OnItemClickListener {

    public static final int VIEW_PAGER_ACTIVITY = 0;
    public static final int TAB_HOST_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.mainListView);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.nesting_types, R.layout.row_nested_type_label);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        switch (position) {
            case VIEW_PAGER_ACTIVITY:
                startActivity(new Intent(MainActivity.this, ViewPagerFragmentActivity.class));
                break;
            case TAB_HOST_ACTIVITY:
                startActivity(new Intent(MainActivity.this, TabHostFragmentActivity.class));
                break;
        }
    }
}
