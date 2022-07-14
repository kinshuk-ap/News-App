//package com.example.newsapp
//
//import androidx.room.*
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface ArticleDao {
//    @Query("SELECT * FROM articles")
//    fun getAllArticles(): Flow<List<Article>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertArticle(aricles: List<Article>)
//
//    @Query("DELETE * from Articles")
//    suspend fun deleteArticles()
//}