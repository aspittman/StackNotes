package com.affinityapps.stacknotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = StackFragment()
        fragmentTransaction.add(R.id.test_frame, fragment)
        fragmentTransaction.commit()

    }
}