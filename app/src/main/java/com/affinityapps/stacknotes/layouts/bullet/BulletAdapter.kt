package com.affinityapps.stacknotes.layouts.bullet

import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.R


class BulletAdapter(
    private val dataSet: ArrayList<String>,
    private var bulletInterface: BulletInterface,
    private val bulletActivity: BulletActivity
) :
    RecyclerView.Adapter<BulletAdapter.ViewHolder>() {

    inner class ViewHolder(view: View, bulletInterface: BulletInterface) :
        RecyclerView.ViewHolder(view) {

        val bullet: TextView
        private val userText: EditText

        init {
            bullet = view.findViewById(R.id.text_bullet)
            userText = view.findViewById(R.id.bullet_text_edit)
            bullet.setOnCreateContextMenuListener(bulletActivity)
            bulletActivity.registerForContextMenu(bullet)

            userText.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                    val position: Int = adapterPosition
                    bulletInterface.rowToAdd(position, userText)
                    return@OnKeyListener true
                }
                if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_UP) {
                    val position: Int = adapterPosition
                    bulletInterface.rowToDelete(position, userText)
                    return@OnKeyListener true
                }
                false
            })
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.bullet_page_item, viewGroup, false)

        return ViewHolder(view, bulletInterface)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bullet.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}