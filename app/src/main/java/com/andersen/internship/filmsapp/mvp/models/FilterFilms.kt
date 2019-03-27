package com.andersen.internship.filmsapp.mvp.models

import android.util.Log
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilter
import com.andersen.internship.filmsapp.pojo.films.Film
import io.reactivex.Flowable
import io.reactivex.Single

class FilterFilms: ModelFilter{

    override var fullListFilms: List<Film> = emptyList()

    override fun search(inputText: String, selectedParameter: String): Single<List<Film>>{
        return if (inputText == ""){
            Single.just(fullListFilms)
        }else{
            executeFiltering(inputText, selectedParameter)
        }
    }

    private fun executeFiltering(inputText: String, selectedParameter: String) = Flowable
            .just(fullListFilms)
            //emit list one by one
            .flatMapIterable { films -> films }
            .filter {
                when(selectedParameter){
                    Film::genre.name -> filterItemByListField(it.genre, inputText)
                    Film::country.name -> filterItemByListField(it.country, inputText)
                    Film::year.name -> filterByYear(it.year, inputText)
                    else -> {false}
                }
            }
            .toList()

    private fun filterItemByListField(genreList: List<String>, inputText: String)
            = genreList.joinToString { it.toLowerCase() }.contains(inputText.toLowerCase())

    private fun filterByYear(year: Int, inputText: String) = year.toString().contains(inputText)
}