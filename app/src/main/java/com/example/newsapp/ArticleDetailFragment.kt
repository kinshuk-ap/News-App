package com.example.newsapp

import android.net.Uri
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import com.bumptech.glide.Glide

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"


class ArticleDetailFragment : Fragment() {
    private var title: String? = null
    private var url: String? = null
    private var urlToImage: String? = null
    private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_article_detail, container, false)
        arguments?.let {
            title       = it.getString(ARG_PARAM1)
            url         = it.getString(ARG_PARAM2)
            urlToImage  = it.getString(ARG_PARAM3)
            description = it.getString(ARG_PARAM4)

            title?.let { Log.d("title", it) }
            url?.let { Log.d("title", it) }
            urlToImage?.let { Log.d("title", it) }
            description?.let { Log.d("title", it) }



            val titleView: TextView  = view.findViewById(R.id.detailTitle)
            val imgUrl   : ImageView = view.findViewById(R.id.detailImage)
            val urlView  : TextView  = view.findViewById(R.id.link)
            val desc     : TextView  = view.findViewById(R.id.detailDesc)

            titleView.text = title.toString()
            desc.text      = description
            Glide.with(this).load(urlToImage).into(imgUrl)
            urlView.text = "Read Complete Article"

            urlView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                    val builder = CustomTabsIntent.Builder()
                    val customTabsIntent = builder.build()
                    if (view != null) {
                        customTabsIntent.launchUrl(view.context, Uri.parse(url))
                    }
                }
            })
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(article: Article) =
            ArticleDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, article.title)
                    putString(ARG_PARAM2, article.url)
                    putString(ARG_PARAM3, article.urlToImage)
                    putString(ARG_PARAM4, article.description)
                }
            }
    }
}