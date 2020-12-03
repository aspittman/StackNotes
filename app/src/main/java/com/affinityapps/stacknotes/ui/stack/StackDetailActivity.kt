package com.affinityapps.stacknotes.ui.stack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.affinityapps.stacknotes.databinding.ActivityStackDetailBinding

class StackDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStackDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStackDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var editText = binding.notepad.setText("This is a test")
    }
}