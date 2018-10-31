package com.burnside.digital.nestedfragments.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.burnside.digital.nestedfragments.R

/**
 * The child fragment is no different than any other fragment other than it is now being maintained by
 * a child FragmentManager.
 */
class ChildFragment : Fragment(), OnClickListener {

  private var position: Int = 0

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View? {
    position = arguments?.getInt(POSITION_KEY) ?: 0

    val root = inflater.inflate(R.layout.fragment_child, container, false)

    (root?.findViewById(R.id.textViewPosition) as TextView).apply {
      text = String.format("%s", position)
      setOnClickListener(this@ChildFragment)
    }

    return root
  }

  override fun onClick(v: View) {
    Toast.makeText(v.context, "Clicked Position: $position", Toast.LENGTH_LONG).show()
  }

  companion object {
    const val POSITION_KEY = "FragmentPositionKey"
    fun newInstance(args: Bundle): ChildFragment = ChildFragment().apply { arguments = args }
  }
}
