package com.rivskyinc.bebetter.presentation.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.rivskyinc.bebetter.domain.entities.Blog

class PostsItemCallback : DiffUtil.ItemCallback<Blog>() {

    override fun areItemsTheSame(oldItem: Blog, newItem: Blog): Boolean {
        return oldItem.title == newItem.title
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Blog, newItem: Blog): Boolean {

        return oldItem == newItem

    }

}