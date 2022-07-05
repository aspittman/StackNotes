package com.affinityapps.stacknotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}