package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Observable

class MainModel: ModelFilmsInterface {
    override fun loadFilms(): Observable<ListFilms> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}