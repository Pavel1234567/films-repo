package com.andersen.internship.filmsapp.ui.adapters

import android.app.Activity
import android.graphics.Point
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
import kotlin.math.roundToInt

class FilmItemAdapter(private val activity: Activity) : RecyclerView.Adapter<FilmItemAdapter.FilmsHolder>() {

    private lateinit var sizeOfImageView: SizeOfView

    var listFilms = emptyList<Film>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): FilmsHolder {

        sizeOfImageView = SizeCalculator(activity).calculateWidthAndHeightOfView()
        val cardView = LayoutInflater.from(activity).inflate(R.layout.item_films, viewGroup, false)
        return FilmsHolder(cardView)
    }

    override fun getItemCount(): Int = listFilms.size

    override fun onBindViewHolder(filmsHolder: FilmsHolder, p1: Int) {

        val imageView = filmsHolder.imageViewPoster
        imageView.layoutParams.width = sizeOfImageView.width
        imageView.layoutParams.height = sizeOfImageView.height

        val film = listFilms[p1]
        filmsHolder.titleTextView.setText(film.title)
        Picasso.get()
            .load(film.image)
            .into(imageView)
    }

    class FilmsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.titleTextView
        val imageViewPoster: ImageView = itemView.imageViewPoster
    }

    class SizeCalculator(private val activity: Activity){

        private var widthScreen: Int = 0


        fun calculateWidthAndHeightOfView(): SizeOfView{

            val recyclerViewMargin = activity.resources.getDimension(R.dimen.recycler_view_margin).roundToInt()
            val linearLayoutPadding = activity.resources.getDimension(R.dimen.linear_layout_padding).roundToInt()
            val cardViewLayoutMargin = activity.resources.getDimension(R.dimen.card_view_layout_margin).roundToInt()
            val spanCount = calculateSpanCount()

            val widthImage = (calculateWidthScreen() - 2 * (recyclerViewMargin - spanCount * (linearLayoutPadding - cardViewLayoutMargin)))/spanCount
            val heightImage = widthImage * 3/2

            return SizeOfView(widthImage, heightImage)
        }

        fun calculateSpanCount(): Int{

            var spanCount: Int = calculateWidthScreen()/IMAGET_VIEW_APPROXIMATE_WIDTH
            if(spanCount < MIN_SPAN_COUNT) spanCount = MIN_SPAN_COUNT
            return spanCount
        }

        fun calculateWidthScreen():Int{
            if (widthScreen == 0) {
                val display = activity.windowManager.defaultDisplay
                val size = Point()
                display.getSize(size)
                widthScreen = size.x
            }
            return widthScreen
        }
    }

    data class SizeOfView(val width: Int, val height: Int)
}

private val IMAGET_VIEW_APPROXIMATE_WIDTH = 256
private val MIN_SPAN_COUNT = 2
private val HEIGHT_WIDTH_RELATION = 3/2
