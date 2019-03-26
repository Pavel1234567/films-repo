package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.Film
import io.reactivex.Single

interface ModelFilter {

    var fullListFilms: List<Film>
    fun search(inputText: String, selectedParameter: String): Single<List<Film>>
}