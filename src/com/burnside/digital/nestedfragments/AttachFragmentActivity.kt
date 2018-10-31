package com.burnside.digital.nestedfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class AttachFragmentActivity : FragmentActivity() {

  override fun onCreate(state: Bundle?) {
    super.onCreate(state)

    intent.extras?.apply {
      setTitle(getInt(ACTIVITY_TITLE_KEY))

      val tag = getString(FRAGMENT_TAG_KEY)
      supportFragmentManager.apply {
        if (findFragmentByTag(tag) == null) {
          beginTransaction().apply {
            add(android.R.id.content, Fragment.instantiate(this@AttachFragmentActivity, tag), tag)
            commit()
          }
        }
      }
    }
  }

  companion object {
    const val FRAGMENT_TAG_KEY = "FragmentTagKey"
    const val ACTIVITY_TITLE_KEY = "ActivityTitleKey"
  }
}