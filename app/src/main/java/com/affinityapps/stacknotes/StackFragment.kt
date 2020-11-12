package com.affinityapps.stacknotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.affinityapps.stacknotes.databinding.FragmentStackBinding

class StackFragment : Fragment() {
    private var _binding: FragmentStackBinding? = null
    private val binding get() = _binding!!

    private lateinit var galleryData: ArrayList<Stack>
    private lateinit var galleryAdapter: StackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
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
            layoutManager = GridLayoutManager(context, 3)
            adapter = StackAdapter(galleryData)
            itemAnimator = DefaultItemAnimator()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


