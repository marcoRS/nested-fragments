package com.burnside.digital.nestedfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.burnside.digital.nestedfragments.fragment.ParentTabHostFragment;
import com.burnside.digital.nestedfragments.fragment.ParentViewPagerFragment;
import com.burnside.digital.nestedfragments.fragment.TabHostLayoutFragment;

public class NestListActivity extends FragmentActivity implements OnItemClickListener {

    public static final int FRAGMENT_WITH_VIEWPAGER_FRAGMENTS = 0;
    public static final int FRAGMENT_WITH_TAB_HOST_XML = 1;
    public static final int FRAGMENT_WITH_TAB_HOST = 2;
    public static final int ACTIVITY_WITH_FRAGMENT_TAB_HOST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_list);

        ListView listView = (ListView) findViewById(R.id.mainListView);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.nesting_types, R.layout.row_nested_type_label);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        switch (position) {
            case FRAGMENT_WITH_VIEWPAGER_FRAGMENTS:
                startActivity(getIntent(ParentViewPagerFragment.TAG, R.string.viewpager_title));
                break;
            case ACTIVITY_WITH_FRAGMENT_TAB_HOST:
                startActivity(new Intent(this, TabHostFragmentActivity.class));
                break;
            case FRAGMENT_WITH_TAB_HOST_XML:
                startActivity(getIntent(TabHostLayoutFragment.TAG, R.string.activity_title_tabhost_layout));
                break;
            case FRAGMENT_WITH_TAB_HOST:
                startActivity(getIntent(ParentTabHostFragment.TAG,R.string.activity_title_tabhost_as_ui));
        }
    }

    private Intent getIntent(String fragmentTag, int titleResId) {
        Intent intent = new Intent(this, AttachFragmentActivity.class);
        Bundle extras = new Bundle();
        extras.putInt(AttachFragmentActivity.ACTIVITY_TITLE_KEY, titleResId);
        extras.putString(AttachFragmentActivity.FRAGMENT_TAG_KEY, fragmentTag);
        intent.putExtras(extras);
        return intent;
    }
}
