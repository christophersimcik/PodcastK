package com.example.chris.podcastk

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.genres_item_row.view.*

class GenreAdapter(private val genres : List<String>) : RecyclerView.Adapter<GenreAdapter.GenreHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAdapter.GenreHolder {
        val inflatedView = parent.inflate(R.layout.genres_item_row, false)
        return GenreHolder(inflatedView)
    }

    override fun getItemCount() = genres.size

    override fun onBindViewHolder(holder: GenreAdapter.GenreHolder, position: Int) {
        var s : String = genres[position];
        holder.popText(s)
    }

    class GenreHolder(v : View) : RecyclerView.ViewHolder(v),View.OnClickListener{
        private var view : View = v
        private var txt : String = ""
        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v : View) {

        }
        fun popText(s : String) {
            view.genre_txt.text = s

        }

    }
}