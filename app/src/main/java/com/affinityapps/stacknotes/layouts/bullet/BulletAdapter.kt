package com.affinityapps.stacknotes.layouts.bullet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.R

class BulletAdapter (private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<BulletAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bullet: TextView
        private val userText : EditText

        init {
            bullet = view.findViewById(R.id.text_bullet)
            userText = view.findViewById(R.id.text_edit)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.bullet_page_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bullet.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}