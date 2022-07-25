package com.geektech.newsapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentHomeBinding
import com.geektech.newsapp.models.News

class HomeFragment : Fragment() {
    private lateinit var adapter: NewsAdapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = NewsAdapter()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.newsFragment2)
        }
        parentFragmentManager.setFragmentResultListener(
            "rk_news",
            viewLifecycleOwner
        ) { requestKey, bundle ->

            val news = bundle.getSerializable("news") as News
            adapter.addItem(news)
            binding.recyclerView.adapter = adapter
            Log.e("Home", "news: $news")
            Log.e("Home", "text: ${news.title}")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}