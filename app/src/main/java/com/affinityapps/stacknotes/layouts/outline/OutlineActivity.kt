package com.affinityapps.stacknotes.layouts.outline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.affinityapps.stacknotes.databinding.ActivityOutlineBinding

class OutlineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutlineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutlineBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}