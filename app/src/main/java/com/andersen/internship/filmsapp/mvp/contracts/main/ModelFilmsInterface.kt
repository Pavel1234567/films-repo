package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.FilmDescription
import com.andersen.internship.filmsapp.pojo.films.ListMedia
import io.reactivex.Observable

interface ModelFilmsInterface {

    fun loadFilms(): Observable<ListMedia>

    fun loadFilmDescription(): Observable<FilmDescription>
}