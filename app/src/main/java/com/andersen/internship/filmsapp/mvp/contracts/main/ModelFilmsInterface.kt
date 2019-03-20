package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Flowable
import io.reactivex.Observable

interface ModelFilmsInterface {

    fun loadFilms(): Flowable<ListFilms>
}