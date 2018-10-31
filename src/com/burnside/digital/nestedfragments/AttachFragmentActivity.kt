package com.burnside.digital.nestedfragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class AttachFragmentActivity : AppCompatActivity() {

  override fun onCreate(state: Bundle?) {
    super.onCreate(state)

    supportActionBar?.apply {
      setBackgroundDrawable(ColorDrawable(Color.rgb(13, 79, 72)))
    }

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