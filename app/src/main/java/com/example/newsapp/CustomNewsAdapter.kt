package com.example.newsapp

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomNewsAdapter(private val dataSet: ArrayList<Article>): RecyclerView.Adapter<CustomNewsAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val newsTitle: TextView
        val newsImg  : ImageView
        val newsDesc : TextView
        init {
            newsTitle = view.findViewById(R.id.newsTitle)
            newsImg   = view.findViewById(R.id.newsImage)
            newsDesc  = view.findViewById(R.id.newsDesc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.news_display, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currNews = dataSet.get(position)
        holder.newsTitle.text = currNews.title
        holder.newsDesc.text = currNews.description
        Glide.with(holder.itemView.context).load(currNews.urlToImage).into(holder.newsImg)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}