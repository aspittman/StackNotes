package com.affinityapps.stacknotes.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.affinityapps.stacknotes.databinding.ActivityBulletBinding

class BulletActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBulletBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBulletBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}