package com.geektech.newsapp.ui.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.ItemFriendsBinding

class FriendsAdapter(val context: Context, val navController: NavController) :
    RecyclerView.Adapter<FriendsAdapter.FriendViewHolder>() {
    private val imageView = arrayListOf(

        R.drawable.ava_four,
        R.drawable.ava_two,
        R.drawable.ava_three,
        R.drawable.ava_four,
        R.color.purple_700,
        R.color.teal_200,
        R.color.teal_700
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        return FriendViewHolder(
            ItemFriendsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = 7


    inner class FriendViewHolder(private var binding: ItemFriendsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.avatarka.setImageResource(imageView[position])
        }
    }

}