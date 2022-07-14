package com.example.newsapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Articles")
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    @PrimaryKey
    val title: String,
    val url: String,
    val urlToImage: String
): Serializable