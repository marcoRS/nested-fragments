package com.burnside.digital.nestedfragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTabHost
import com.burnside.digital.nestedfragments.R

class TabHostLayoutFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View? {
    val root = inflater.inflate(R.layout.fragment_tab_host_layout, container, false)

    root.findViewById<FragmentTabHost>(R.id.fragmentTabHost)
        .apply {
          // Important: Must use child FragmentManager.
          setup(activity, childFragmentManager, android.R.id.tabcontent)
          addPositionTab(1)
          addPositionTab(2)
          addPositionTab(3)
          addPositionTab(4)
        }

    return root
  }

  companion object {
    val TAG: String = TabHostLayoutFragment::class.java.name
  }
}
