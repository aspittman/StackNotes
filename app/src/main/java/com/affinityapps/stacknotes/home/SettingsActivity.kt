package com.affinityapps.stacknotes.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.affinityapps.stacknotes.databinding.ActivitySettingsBinding
import com.google.android.material.snackbar.Snackbar


class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val darkLightSwitch = binding.darkLightSwitch

        darkLightSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            Snackbar.make(buttonView, "Switch state checked $isChecked", Snackbar.LENGTH_LONG)
                .setAction("ACTION", null).show()
        }

    }

    private fun darkLightMode() {
        val nightMode: Int = AppCompatDelegate.getDefaultNightMode()

        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}