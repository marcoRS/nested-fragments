package com.burnside.digital.nestedfragments.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTabHost
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.burnside.digital.nestedfragments.R

class TabHostLayoutFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val root = inflater!!.inflate(R.layout.fragment_tab_host_layout, container, false)

    val tabHost = root.findViewById(android.R.id.tabhost) as FragmentTabHost
    // Important: Must use child FragmentManager.
    tabHost.setup(activity, childFragmentManager, android.R.id.tabcontent)

    val arg1 = Bundle()
    arg1.putInt(ChildFragment.POSITION_KEY, 1)
    tabHost.addTab(tabHost.newTabSpec("ChildTag1").setIndicator("Child Fragment 1"),
        ChildFragment::class.java, arg1)

    val arg2 = Bundle()
    arg2.putInt(ChildFragment.POSITION_KEY, 2)
    tabHost.addTab(tabHost.newTabSpec("ChildTag2").setIndicator("Child Fragment 2"),
        ChildFragment::class.java, arg2)

    return root
  }

  companion object {
    val TAG: String = TabHostLayoutFragment::class.java.name
  }
}
