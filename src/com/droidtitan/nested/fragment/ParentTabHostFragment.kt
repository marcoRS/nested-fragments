package com.droidtitan.nested.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTabHost
import com.droidtitan.nested.R

class ParentTabHostFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View? {

    return FragmentTabHost(activity).apply {
      // Important: Must use Child FragmentManager
      setup(activity, childFragmentManager, R.layout.fragment_parent_tab_host)
      addPositionTab(1)
      addPositionTab(2)
    }
  }

  companion object {
    val TAG: String = ParentTabHostFragment::class.java.name
  }
}
