package com.example.basictv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {
    //TODO : R.id.main_browse_fragment laden
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}