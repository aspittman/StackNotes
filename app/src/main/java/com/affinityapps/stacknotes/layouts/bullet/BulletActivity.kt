package com.affinityapps.stacknotes.layouts.bullet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.R
import com.affinityapps.stacknotes.databinding.ActivityBulletBinding


class BulletActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBulletBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBulletBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val randomList = ArrayList<String>()
        randomList.add("\u2022 ")

        val recyclerView: RecyclerView = findViewById(R.id.bullet_list_view)
        LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        ).apply {
            recyclerView.layoutManager = this
        }
        recyclerView.adapter = BulletAdapter(randomList)
    }
}