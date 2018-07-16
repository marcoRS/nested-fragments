package com.burnside.digital.nestedfragments.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.burnside.digital.nestedfragments.R

/**
 * This fragment hosts the viewpager that will use a FragmentPagerAdapter to display child fragments.
 */
class ParentViewPagerFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val root = inflater!!.inflate(R.layout.fragment_parent_viewpager, container, false)

    val viewPager = root.findViewById(R.id.viewPager) as ViewPager
    // Important: Must use the child FragmentManager or you will see side effects.
    viewPager.adapter = MyAdapter(childFragmentManager)

    return root
  }

  class MyAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int = 4

    override fun getItem(position: Int): Fragment {
      val args = Bundle().apply { putInt(ChildFragment.POSITION_KEY, position) }
      return ChildFragment.newInstance(args)
    }

    override fun getPageTitle(position: Int): CharSequence = "Child Fragment $position"
  }

  companion object {
    val TAG: String = ParentViewPagerFragment::class.java.name
  }
}
