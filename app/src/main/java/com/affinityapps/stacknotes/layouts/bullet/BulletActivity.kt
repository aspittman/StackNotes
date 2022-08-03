package com.affinityapps.stacknotes.layouts.bullet

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.databinding.ActivityBulletBinding


class BulletActivity : AppCompatActivity(), BulletInterface {

    private lateinit var binding: ActivityBulletBinding
    private val randomList = ArrayList<String>()
    private val adapter = BulletAdapter(randomList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBulletBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.bulletListView
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        randomList.add("\u2022 ")
        randomList.add("\u2022 ")
        randomList.add("\u2022 ")
    }

    override fun rowToAdd(position: Int) {
        randomList.add("\u2022 ")
        adapter.notifyItemInserted(position + 1)
    }

    override fun rowToDelete(position: Int, textFromUser: EditText) {
        if(textFromUser.length() == 0) {
            randomList.removeAt(position)
            adapter.notifyItemRemoved(position)
        }
    }
}