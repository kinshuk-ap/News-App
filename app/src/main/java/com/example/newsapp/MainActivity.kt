package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://newsapi.org/"

    private val newsArray = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNewsData()
        val arr = arrayOf("sa", "rer", "vsd", "ds", "sdvc")
        val temp = Article(
            "das",
            "asd",
            "Nothing phone (1) comes with a 50MP primary camera that has a Sony IMX766 sensor.",
            "dsa",
            "Nothing phone (1) price leaked ahead of launch- Economic Times",
            "https://economictimes.indiatimes.com/magazines/panache/nothing-phone-1-price-leaked-ahead-of-launch-brand-teases-photography-samples/articleshow/92794195.cms",
            "https://img.etimg.com/thumb/msid-92794219,width-1070,height-580,imgsize-38156,overlay-etpanache/photo.jpg"
        )
        newsArray.add(temp)

        val adapter = CustomNewsAdapter(newsArray)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

    }
    fun getNewsData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getNewsResponse()
        retrofitData.enqueue(object : Callback<NewsData?> {
            override fun onResponse(call: Call<NewsData?>, response: Response<NewsData?>) {

                val newsArticle: List<Article>? = response.body()?.getArticles()

                Log.d("news", newsArticle.toString())

//                if (newsArticle != null) {
//                    for (i in newsArticle.indices) {
//                        val currArticle = Article(
//                            newsArticle[i].author,
//                            newsArticle[i].content,
//                            newsArticle[i].description,
//                            newsArticle[i].publishedAt,
//                            newsArticle[i].source,
//                            newsArticle[i].title,
//                            newsArticle[i].url,
//                            newsArticle[i].urlToImage
//                        )
//                        newsArray.add(currArticle)
//                    }
//                    mAdapter.updateNews(newsArray)
//                }

            }
            override fun onFailure(call: Call<NewsData?>, t: Throwable) {
                Log.d("news", "ERROR -> "+t.message)
            }

        })
    }
}