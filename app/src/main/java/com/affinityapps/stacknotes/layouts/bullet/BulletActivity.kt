package com.affinityapps.stacknotes.layouts.bullet

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.R
import com.affinityapps.stacknotes.databinding.ActivityBulletBinding


class BulletActivity : AppCompatActivity(), BulletInterface {

    private lateinit var binding: ActivityBulletBinding
    private val bulletList = ArrayList<String>()
    private val adapter = BulletAdapter(bulletList, this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBulletBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.bulletListView
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        bulletList.add("\u2022 ")
        bulletList.add("\u2022 ")
        bulletList.add("\u2022 ")
    }

    override fun rowToAdd(position: Int) {
        bulletList.add("\u2022 ")
        adapter.notifyItemInserted(position + 1)
    }

    override fun rowToDelete(position: Int, textFromUser: EditText) {
        if (textFromUser.length() == 0) {
            bulletList.removeAt(position)
            adapter.notifyItemRemoved(position)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.bullet_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.bullet_menu_option -> {
                Toast.makeText(applicationContext, "bullet test", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.numbers_menu_option -> {
                Toast.makeText(applicationContext, "number test", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.checkbox_menu_option -> {
                Toast.makeText(applicationContext, "checkbox test", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}