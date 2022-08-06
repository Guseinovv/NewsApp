package com.geektech.newsapp.ui.board

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.geektech.newsapp.Prefs
import com.geektech.newsapp.databinding.ItemBoardBinding
import com.geektech.newsapp.R
import com.geektech.newsapp.models.Board

class BoardAdapter(val context: Context, val navController: NavController) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {
 private val list = arrayListOf<Board>(
 )

   inner class BoardViewHolder(private var binding: ItemBoardBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(board: Board) {
           binding.tvTitle.text = board.title
           binding.tvText.text = board.description
           binding.imageView.setAnimation(board.lottie)
           if (list.lastIndexOf(board) == list.lastIndex) {
               binding.btnStart.visibility = View.VISIBLE
           } else {
               binding.btnStart.visibility = View.INVISIBLE
           }
           binding.btnStart.setOnClickListener {
               Prefs(context).saveState()
               navController.navigateUp()
           }
       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount() = list.size
    fun addItem(board: Board) {
        list.add(board)
    }
}