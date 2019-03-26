package com.andersen.internship.filmsapp.ui.adapters

import android.widget.Filter
import com.andersen.internship.filmsapp.pojo.films.FilmDTO

class FilterFilms(private val adapter: FilmItemAdapter): Filter() {

    private val fullListFilms = adapter.listFilms.toList()

    override fun performFiltering(constraint: CharSequence?): FilterResults {

        val filteredListFilms = mutableListOf<FilmDTO>()

        if (constraint.isNullOrEmpty()){
            filteredListFilms.addAll(fullListFilms)
        }else{

            val filterPattern = constraint.toString().toLowerCase().trim()
            fullListFilms.forEach {
                if (it.title.contains(filterPattern)){
                    filteredListFilms.add(it)
                }
            }
        }

        val results = FilterResults()
        results.values = filteredListFilms
        return results
    }

    override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
        adapter.listFilms = filterResults?.values as List<FilmDTO>
    }
}