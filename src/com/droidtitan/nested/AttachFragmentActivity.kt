package com.droidtitan.nested

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class AttachFragmentActivity : AppCompatActivity() {

  override fun onCreate(state: Bundle?) {
    super.onCreate(state)

    supportActionBar?.apply {
      setBackgroundDrawable(ColorDrawable(Color.rgb(13, 79, 72)))
      setDisplayHomeAsUpEnabled(true)
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

  override fun onOptionsItemSelected(item: MenuItem): Boolean =
      when (item.itemId) {
        android.R.id.home -> onBackPressed().let { true }
        else -> super.onOptionsItemSelected(item)
      }

  companion object {
    const val FRAGMENT_TAG_KEY = "FragmentTagKey"
    const val ACTIVITY_TITLE_KEY = "ActivityTitleKey"
  }
}