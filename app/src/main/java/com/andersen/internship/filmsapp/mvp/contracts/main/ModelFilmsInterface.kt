package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Observable
import io.reactivex.Single

interface ModelFilmsInterface {

    fun loadFilms(): Single<ListFilms>
}