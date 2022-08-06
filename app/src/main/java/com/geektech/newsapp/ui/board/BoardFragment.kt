package com.geektech.newsapp.ui.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentBoardBinding
import com.geektech.newsapp.models.Board

class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding
    private lateinit var adapter: BoardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BoardAdapter(requireContext(), findNavController())
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            activity?.finish()
        }
        adapter.addItem(Board(R.raw.lotti_news1, "новости крч", "новости тож"))
        adapter.addItem(Board(R.raw.lotti_news2, "новости крч", "новости тож"))
        adapter.addItem(Board(R.raw.lotti_news3, "новости крч", "новости тож"))
        binding.view.adapter = adapter
        binding.dots.setViewPager2(binding.view)

    }

}