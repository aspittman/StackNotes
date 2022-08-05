package com.affinityapps.stacknotes.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.R
import com.affinityapps.stacknotes.databinding.ActivityMainBinding
import com.affinityapps.stacknotes.layouts.bullet.BulletActivity
import com.affinityapps.stacknotes.layouts.note.NoteActivity
import com.affinityapps.stacknotes.layouts.outline.OutlineActivity
import com.affinityapps.stacknotes.model.HomeImages
import androidx.recyclerview.widget.DefaultItemAnimator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeImageList = ArrayList<HomeImages>()
        homeImageList.add(HomeImages(R.drawable.ic_scatter))
        homeImageList.add(HomeImages(R.drawable.ic_science))
        homeImageList.add(HomeImages(R.drawable.ic_scatter))
        homeImageList.add(HomeImages(R.drawable.ic_science))
        homeImageList.add(HomeImages(R.drawable.ic_scatter))
        homeImageList.add(HomeImages(R.drawable.ic_science))
        homeImageList.add(HomeImages(R.drawable.ic_science))
        homeImageList.add(HomeImages(R.drawable.ic_scatter))
        homeImageList.add(HomeImages(R.drawable.ic_science))
        homeImageList.add(HomeImages(R.drawable.ic_scatter))
        homeImageList.add(HomeImages(R.drawable.ic_science))
        homeImageList.add(HomeImages(R.drawable.ic_scatter))
        homeImageList.add(HomeImages(R.drawable.ic_science))
        homeImageList.add(HomeImages(R.drawable.ic_scatter))

       val recyclerView:RecyclerView = findViewById(R.id.main_grid)
        GridLayoutManager(
            this,
            2,
            RecyclerView.VERTICAL,
            false
        ).apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = this
            recyclerView.itemAnimator = DefaultItemAnimator()
        }
        recyclerView.adapter = HomeAdapter(homeImageList)

        binding.fab1.setOnClickListener { val intent = Intent(this, NoteActivity::class.java)
            startActivity(intent)
        }

        binding.fab2.setOnClickListener { val intent = Intent(this, BulletActivity::class.java)
            startActivity(intent)
        }

        binding.fab3.setOnClickListener { val intent = Intent(this, OutlineActivity::class.java)
            startActivity(intent)
        }
    }
}