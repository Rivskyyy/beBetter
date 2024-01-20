package com.rivskyinc.bebetter.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivskyinc.bebetter.databinding.ItemLayoutBinding
import com.rivskyinc.bebetter.domain.entities.Blog

class MyListAdapter(private val itemClickListener: (Blog, Int) -> Unit)
    : ListAdapter<Blog, MyListAdapter.BlogViewHolder>(PostsItemCallback()) {

    class BlogViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {

        val listOfPosts = getItem(position)
        holder.binding.titleView.text = listOfPosts.title
        val url = listOfPosts.thumbnail

        Glide.with(holder.itemView)
            .load(url)
            .into(holder.binding.thumbnailImage)

        holder.itemView.setOnClickListener {
            val post = getItem(position)
            itemClickListener(post, position)
        }

    }

}
