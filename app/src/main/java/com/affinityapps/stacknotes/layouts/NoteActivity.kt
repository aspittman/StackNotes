package com.affinityapps.stacknotes.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.affinityapps.stacknotes.databinding.ActivityMainBinding
import com.affinityapps.stacknotes.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}