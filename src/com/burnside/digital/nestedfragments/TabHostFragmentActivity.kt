package com.burnside.digital.nestedfragments

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTabHost
import com.burnside.digital.nestedfragments.fragment.ParentViewPagerFragment
import com.burnside.digital.nestedfragments.fragment.SingleChildFragment

class TabHostFragmentActivity : FragmentActivity() {

  override fun onCreate(state: Bundle?) {
    super.onCreate(state)
    setTitle(R.string.activity_tabhost_title)

    val tabs = FragmentTabHost(this)
    tabs.apply {
      setup(this@TabHostFragmentActivity, supportFragmentManager, R.layout.activity_nest_list)
      addTab(tabs.newTabSpec("ParentViewPagerFragment").setIndicator("View Pager"), ParentViewPagerFragment::class.java, null)
      addTab(tabs.newTabSpec("SingleFragment").setIndicator("Single Fragment"), SingleChildFragment::class.java, null)
    }

    setContentView(tabs)
  }
}
