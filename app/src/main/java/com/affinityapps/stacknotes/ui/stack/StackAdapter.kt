package com.affinityapps.stacknotes.ui.stack

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stacknotes.databinding.StackListItemsBinding

class StackAdapter(private val notesArrayList: List<Stack>
) :
        RecyclerView.Adapter<StackAdapter.StackItemsViewHolder>() {

    inner class StackItemsViewHolder(binding: StackListItemsBinding) :
            RecyclerView.ViewHolder(binding.root) {

        var playerImage: ImageView = binding.playerImageIcon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StackItemsViewHolder {
        return StackItemsViewHolder(
                StackListItemsBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: StackItemsViewHolder, position: Int) {
        val stack = notesArrayList[position]
        holder.playerImage.setImageResource(stack.noteImageIcon)
        Log.d("Adapter", "Position is at $position")
    }

    override fun getItemCount() = notesArrayList.size
}