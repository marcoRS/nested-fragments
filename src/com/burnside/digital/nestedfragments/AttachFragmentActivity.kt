package com.burnside.digital.nestedfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

class AttachFragmentActivity : FragmentActivity() {

  override fun onCreate(state: Bundle?) {
    super.onCreate(state)

    intent.extras?.apply {
      setTitle(getInt(ACTIVITY_TITLE_KEY))

      val tag = getString(FRAGMENT_TAG_KEY)
      val fm = supportFragmentManager

      if (fm.findFragmentByTag(tag) == null) {
        fm.beginTransaction()
            .apply {
              add(android.R.id.content, Fragment.instantiate(this@AttachFragmentActivity, tag), tag)
              commit()
            }
      }
    }
  }

  companion object {
    const val FRAGMENT_TAG_KEY = "FragmentTagKey"
    const val ACTIVITY_TITLE_KEY = "ActivityTitleKey"
  }
}