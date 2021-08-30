package com.example.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): NewsHolder {
        return NewsHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = 8

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        // bind ui item
    }

    inner class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}