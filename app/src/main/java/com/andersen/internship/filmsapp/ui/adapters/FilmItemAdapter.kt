package com.andersen.internship.filmsapp.ui.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.pojo.films.FilmDTO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_films.view.*
import javax.inject.Inject

class FilmItemAdapter @Inject constructor(
    private val widthAndHeightOfImageView: Pair<Int, Int>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<FilmItemAdapter.FilmsHolder>() {

    var listFilms = emptyList<FilmDTO>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): FilmsHolder {
        val cardView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_films, viewGroup, false)
        return FilmsHolder(cardView)
    }

    override fun getItemCount(): Int = listFilms.size

    override fun onBindViewHolder(filmsHolder: FilmsHolder, position: Int) {

        val imageView = filmsHolder.imageViewPoster
        imageView.layoutParams.width = widthAndHeightOfImageView.first
        imageView.layoutParams.height = widthAndHeightOfImageView.second

        val film = listFilms[position]
        filmsHolder.titleTextView.setText(film.title)
        Picasso.get()
            .load(film.image)
            .into(imageView)

        filmsHolder.cardView.setOnClickListener { onItemClickListener.onItemClick(film.id) }
    }

    class FilmsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.card_view
        val titleTextView = itemView.titleTextView
        val imageViewPoster = itemView.imageViewPoster
    }

    interface OnItemClickListener{
        fun onItemClick(id: Int)
    }

}

