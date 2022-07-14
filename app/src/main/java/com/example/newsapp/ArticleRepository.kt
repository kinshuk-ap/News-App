//package com.example.newsapp
//
//import androidx.annotation.WorkerThread
//import kotlinx.coroutines.flow.Flow
//
//class ArticleRepository(private val articleDao: ArticleDao) {
//    val allArticles: Flow<List<Article>> = articleDao.getAllArticles()
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun insert(articles: List<Article>){
//        articleDao.insertArticle(articles)
//    }
//}