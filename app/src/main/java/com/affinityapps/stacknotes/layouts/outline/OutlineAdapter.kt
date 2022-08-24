package com.affinityapps.stacknotes.layouts.outline

import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.R

class OutlineAdapter(
    private val outlineDataSet: ArrayList<String>,
    private var outlineInterface: OutlineInterface,
    private val outlineActivity: OutlineActivity
) :
    RecyclerView.Adapter<OutlineAdapter.ViewHolder>() {

    inner class ViewHolder(view: View, outlineInterface: OutlineInterface) :
        RecyclerView.ViewHolder(view) {

        val outline: TextView
        val userText: EditText

        init {
            outline = view.findViewById(R.id.text_outline)
            userText = view.findViewById(R.id.outline_text_edit)
            outline.setOnCreateContextMenuListener(outlineActivity)
            outlineActivity.registerForContextMenu(outline)

            userText.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                    val position: Int = adapterPosition
                    outlineInterface.rowToAdd(position + 1)
                    return@OnKeyListener true
                }
                if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_UP) {
                    val position: Int = adapterPosition
                    outlineInterface.rowToDelete(position, userText)
                    return@OnKeyListener true
                }
                false
            })
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.outline_page_item, viewGroup, false)

        return ViewHolder(view, outlineInterface)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.outline.text = outlineDataSet[position]
        viewHolder.userText.requestFocus()
    }

    override fun getItemCount() = outlineDataSet.size
}