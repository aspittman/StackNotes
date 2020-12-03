package com.affinityapps.stacknotes.ui.stack

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

    private lateinit var stackData: ArrayList<Stack>
    private lateinit var stackAdapter: StackAdapter
    private lateinit var fab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStackBinding.inflate(inflater, container, false)

        stackData = ArrayList()
        stackData.add(Stack(R.drawable.ic_menu_gallery))
        stackData.add(Stack(R.drawable.ic_menu_send))
        stackData.add(Stack(R.drawable.ic_menu_camera))
        stackData.add(Stack(R.drawable.ic_menu_manage))
        stackData.add(Stack(R.drawable.ic_menu_slideshow))

        stackAdapter = StackAdapter(stackData)
        binding.stackRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 3)
            adapter = stackAdapter
            itemAnimator = DefaultItemAnimator()
        }

        stackAdapter.setOnStackItemClickListener(object : StackAdapter.OnStackItemClickListener {

            override fun onStackItemClick(position: Int) {
                val intent = Intent(requireActivity(), StackDetailActivity::class.java)
                startActivity(intent)
                Log.d("ClickPosition", "Clicked and on position $position")
            }
        })
        enableButtonClick()
        return binding.root
    }

    private fun enableButtonClick() {
        fab = binding.fab
        fab.setOnClickListener {
            val position = stackData.size
            stackData.add(position, Stack(R.drawable.ic_menu_send))
            stackAdapter.notifyItemInserted(position)
            Log.i("AddTest", "Position is $position")
            Log.i("ArrayTest", "Position is $stackData")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


