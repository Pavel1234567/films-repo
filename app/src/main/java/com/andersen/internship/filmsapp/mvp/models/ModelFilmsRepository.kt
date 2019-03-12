package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.FilmDescription
import com.andersen.internship.filmsapp.pojo.films.ListMedia
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi): ModelFilmsInterface {

    override fun loadFilmDescription(): Observable<FilmDescription> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadFilms(): Observable<ListMedia> {

        Timber.tag("myLogs").d("loadFilms")

        return filmsApi.getList()
    }
}
