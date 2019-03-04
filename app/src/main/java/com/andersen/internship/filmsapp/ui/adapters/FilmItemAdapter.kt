package com.andersen.internship.filmsapp.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.pojo.films.Film
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_films.view.*

class FilmItemAdapter(private val context: Context) : RecyclerView.Adapter<FilmItemAdapter.FilmsHolder>() {

    var listFilms = emptyList<Film>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): FilmsHolder {

        val cardView = LayoutInflater.from(context).inflate(R.layout.item_films, viewGroup, false)
        return FilmsHolder(cardView)
    }

    override fun getItemCount(): Int = listFilms.size

    override fun onBindViewHolder(filmsHolder: FilmsHolder, p1: Int) {

        val film = listFilms[p1]
        filmsHolder.titleTextView.setText(film.title)

        Picasso.get()
            .load(film.image)
            .into(filmsHolder.imageViewPoster)
    }

    class FilmsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.titleTextView
        val imageViewPoster: ImageView = itemView.imageViewPoster
    }
}