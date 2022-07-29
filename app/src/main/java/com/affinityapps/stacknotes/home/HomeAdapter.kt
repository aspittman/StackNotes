package com.affinityapps.stacknotes.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.R
import com.affinityapps.stacknotes.model.HomeImages


class HomeAdapter (private val dataSet: ArrayList<HomeImages>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val homeImages : ImageView

        init {
            homeImages = view.findViewById(R.id.home_image_views)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_page_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val homeImages: HomeImages = dataSet[position]
        viewHolder.homeImages.setImageResource(homeImages.homeImageIcon)
    }

    override fun getItemCount() = dataSet.size

}