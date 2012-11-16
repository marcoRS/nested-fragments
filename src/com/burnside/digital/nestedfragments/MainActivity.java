package com.burnside.digital.nestedfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.burnside.digital.nestedfragments.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	ListView listView = (ListView) findViewById(R.id.mainListView);
	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.nesting_types,
		android.R.layout.simple_expandable_list_item_1);
	listView.setAdapter(adapter);

	listView.setOnItemClickListener(new OnItemClickListener() {
	    @Override
	    public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
		if (position == 0) {
		    Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
		    MainActivity.this.startActivity(intent);
		} else if (position == 1) {
		    Intent intent = new Intent(MainActivity.this, TabHostFragmentActivity.class);
		    MainActivity.this.startActivity(intent);
		}
	    }
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.activity_main, menu);
	return true;
    }

}
