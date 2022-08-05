package com.geektech.newsapp.ui.home

import android.app.AlertDialog
import android.app.Application
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.newsapp.App
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.FragmentHomeBinding
import com.geektech.newsapp.models.News

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val adapter = NewsAdapter()

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = App.db.dao().getAll()
        binding.recyclerView.adapter = adapter
        adapter.setList(list as ArrayList<News>)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.newsFragment2)
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val list = newText?.let { App.db.dao().getSearch(it) }
                adapter.setList(list as ArrayList<News>)
                return false
            }
        })


        /*parentFragmentManager.setFragmentResultListener(
            "rk_news",
            viewLifecycleOwner
        ) { requestKey, bundle ->

            val news = bundle.getSerializable("news") as News
            adapter.addItem(news)
            binding.recyclerView.adapter = adapter
            Log.e("Home", "news: $news")
            Log.e("Home", "text: ${news.title}")
        }*/
        adapter.onClickLongListener = { position ->
            onLongClickListener(position)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onLongClickListener(position: Int) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Delete item")
        alertDialog.setMessage("Хочешь удолить? сирежа?")
            .setPositiveButton("DA", DialogInterface.OnClickListener { dialog, which ->
                App.db.dao().delete(adapter.getItem(position))
                adapter.deleteItem(position)
                adapter.notifyItemChanged(position)
            }).setNegativeButton("net", DialogInterface.OnClickListener { dialog, which ->

        })
        alertDialog.create().show()

    }

}