package com.burnside.digital.nestedfragments.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTabHost
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.burnside.digital.nestedfragments.R

class ParentTabHostFragment : Fragment() {

  private var fragmentTabHost: FragmentTabHost? = null

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    fragmentTabHost = FragmentTabHost(activity)

    // Important: Must use Child FragmentManager
    fragmentTabHost!!.setup(activity, childFragmentManager, R.layout.fragment_parent_tab_host)

    fun args(position: Int) =  Bundle().apply { putInt(ChildFragment.POSITION_KEY, position) }

    fragmentTabHost!!.addTab(fragmentTabHost!!.newTabSpec("ChildTag1").setIndicator("Child Fragment 1"),
        ChildFragment::class.java, args(1))

    fragmentTabHost!!.addTab(fragmentTabHost!!.newTabSpec("ChildTag2").setIndicator("Child Fragment 2"),
        ChildFragment::class.java, args(2))

    return fragmentTabHost
  }

  override fun onDestroyView() {
    super.onDestroyView()
    fragmentTabHost = null
  }

  companion object {
    val TAG: String = ParentTabHostFragment::class.java.name
  }
}
