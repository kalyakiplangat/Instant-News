package com.thekalya.instantnews.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thekalya.instantnews.R
import com.thekalya.instantnews.data.Articles
import com.thekalya.instantnews.ui.detailnews.DetailActivity

class ArticlesAdapter(
    var context: Context, private val articlesList: List<Articles>
) :
    RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_articles, parent, false)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount() = articlesList.size

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = articlesList[position]
        Glide.with(context)
            .load(article.urlToImage)
            .apply(
                RequestOptions().placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(holder.imageView)

        holder.textTitle.text = article.title
        holder.textDescription.text = article.description
        holder.textAuthor.text = article.author
        holder.textDate.text = article.publishedAt

        holder.itemView.setOnClickListener {
            val article = articlesList[position]
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("url", article.url)
            intent.putExtra("image", article.urlToImage)
            intent.putExtra("title", article.title)
            context.startActivity(intent)
        }
    }

    class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById<ImageView>(R.id.imageView)
        var textTitle = itemView.findViewById<TextView>(R.id.headline_text)
        var textDescription = itemView.findViewById<TextView>(R.id.description_text)
        var textAuthor = itemView.findViewById<TextView>(R.id.author_text)
        var textDate = itemView.findViewById<TextView>(R.id.date_text)


    }


//    inner class ArticlesViewHolder(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//
////        fun bind(articles: Articles) {
////            binding.article = articles
////            binding.executePendingBindings()
////        }
//    }

}