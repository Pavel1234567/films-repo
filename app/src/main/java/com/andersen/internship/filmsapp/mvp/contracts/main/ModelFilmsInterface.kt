package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.Film
import io.reactivex.Single

interface ModelFilmsInterface {

    fun loadFilms(): Single<List<Film>>
}