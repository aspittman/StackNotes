package com.affinityapps.stacknotes.ui.stack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.affinityapps.stacknotes.R
import com.affinityapps.stacknotes.databinding.FragmentStackBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StackFragment : Fragment() {
    private var _binding: FragmentStackBinding? = null
    private val binding get() = _binding!!

    private lateinit var galleryData: ArrayList<Stack>
    private lateinit var galleryAdapter: StackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStackBinding.inflate(inflater, container, false)

        galleryData = ArrayList()
        galleryData.add(Stack(R.drawable.ic_menu_gallery))
        galleryData.add(Stack(R.drawable.ic_menu_send))
        galleryData.add(Stack(R.drawable.ic_menu_camera))
        galleryData.add(Stack(R.drawable.ic_menu_manage))
        galleryData.add(Stack(R.drawable.ic_menu_slideshow))

        galleryAdapter = StackAdapter(galleryData)
        binding.stackRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 3)
            adapter = StackAdapter(galleryData)
            itemAnimator = DefaultItemAnimator()
        }

        enableButtonClick()
        return binding.root
    }

    private fun enableButtonClick() {
        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener {
            val position = galleryData.size
            galleryData.add(position, Stack(R.drawable.ic_menu_send))
            galleryAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


