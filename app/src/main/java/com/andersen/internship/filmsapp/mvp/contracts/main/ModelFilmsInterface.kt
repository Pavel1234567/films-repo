package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Single

interface ModelFilmsInterface {

    fun loadFilms(): Single<ListFilms>
    fun loadFilmById(id: Int): Single<Film>
}