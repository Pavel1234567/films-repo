package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListMedia
import io.reactivex.Observable

class MainModel: ModelFilmsInterface {
    override fun loadFilms(): Observable<ListMedia> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }
}