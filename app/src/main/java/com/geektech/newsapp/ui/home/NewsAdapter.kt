package com.geektech.newsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.newsapp.databinding.ItemNewsBinding
import com.geektech.newsapp.models.News
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private var list = arrayListOf<News>()
    var onClickLongListener: ((Int) -> Unit?)? = null
    inner class NewsViewHolder(private var binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            val simpleDateFormat = SimpleDateFormat("HH:mm, dd MMMM yyy")
            val dateTime = Date(news.createdAd)
            val time: String = simpleDateFormat.format(dateTime)
            binding.tvTime.text = time
            binding.tvTitle.text = news.title
            itemView.setOnLongClickListener{
                onClickLongListener
                    ?.invoke(adapterPosition)
                return@setOnLongClickListener true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
      return  NewsViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }



    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount() = list.size

    fun addItem(news: News?) {
        news?.let {
            list.add(0, it)
            notifyItemInserted(list.indexOf(news))
        }

    }

    fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

    fun setList(arrayList: ArrayList<News>) {
        this.list = arrayList
        notifyDataSetChanged()
    }

    fun getItem(position: Int): News {
        return list[position]
    }
}