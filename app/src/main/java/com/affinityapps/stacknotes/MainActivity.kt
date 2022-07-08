package com.affinityapps.stacknotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val randomList = ArrayList<String>()
        randomList.add("aaaaa")
        randomList.add("bbbbb")
        randomList.add("ccccc")
        randomList.add("ddddd")
        randomList.add("eeeee")

       val recyclerView:RecyclerView = findViewById(R.id.main_grid)
        GridLayoutManager(
            this, // context
            2, // span count
            RecyclerView.VERTICAL, // orientation
            false // reverse layout
        ).apply {
            // specify the layout manager for recycler view
            recyclerView.layoutManager = this
        }
        recyclerView.adapter = NoteAdapter(randomList)

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
//                val intent = Intent(this, SettingsActivity::class.java)
//                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}