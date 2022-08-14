package com.affinityapps.stacknotes.layouts.outline

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
import com.affinityapps.stacknotes.databinding.ActivityOutlineBinding

class OutlineActivity : AppCompatActivity(), OutlineInterface {

    private lateinit var binding: ActivityOutlineBinding
    private val outlineList = ArrayList<String>()
    private val adapter = OutlineAdapter(outlineList, this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutlineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.outlineListView
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        outlineList.add("I ")
    }

    override fun rowToAdd(position: Int) {
        outlineList.add("II ")
        adapter.notifyItemInserted(position + 2)
    }

    override fun rowToDelete(position: Int, textFromUser: EditText) {
        if (textFromUser.length() == 0 && outlineList.size != 1) {
            outlineList.removeAt(position)
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
        inflater.inflate(R.menu.outline_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.roman_numeral -> {
                Toast.makeText(applicationContext, "RN test", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.upper_case_letter -> {
                Toast.makeText(applicationContext, "UCL test", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.number -> {
                Toast.makeText(applicationContext, "number test", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.lower_case_letter -> {
                Toast.makeText(applicationContext, "LCL test", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
