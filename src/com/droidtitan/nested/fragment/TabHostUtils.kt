package com.droidtitan.nested.fragment

import android.os.Bundle
import androidx.fragment.app.FragmentTabHost

fun FragmentTabHost.addPositionTab(position: Int) {
  val arg = Bundle().apply { putInt(ChildFragment.POSITION_KEY, position) }
  val klass = ChildFragment::class.java
  this.addTab(this.newTabSpec("ChildTag$position").setIndicator("Child $position"), klass, arg)
}