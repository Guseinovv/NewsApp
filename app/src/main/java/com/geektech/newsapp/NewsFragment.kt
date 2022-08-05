package com.geektech.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.newsapp.databinding.FragmentNewsBinding
import com.geektech.newsapp.models.News

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            save()
        }
    }

    private fun save() {
        val text = binding.editText.text.toString()
        val news = News(0,text, System.currentTimeMillis())
        App.db.dao().insert(news)
        findNavController().navigateUp()



        //Так тоже можно
//        val bundle = bundleOf("text" to text)
    }
}
//
//private fun save() {
//    val text = binding.editText.text.toString().trim()
//    val news = News(text, System.currentTimeMillis())
//    val bundle = Bundle()
//    bundle.putSerializable("news", news)
//    parentFragmentManager.setFragmentResult("rk_news", bundle)
//    close()
//
//    //Так тоже можно
////        val bundle = bundleOf("text" to text)
//}
//private fun close(){
//    val nav = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main)
//    nav.navigateUp()