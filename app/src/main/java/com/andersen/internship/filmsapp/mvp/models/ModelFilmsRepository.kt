package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.NetworkService
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListMedia
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val networkService: NetworkService): ModelFilmsInterface {

    override fun loadFilms(): Observable<ListMedia> {

        Timber.tag("myLogs").d("loadFilms")

        return networkService
            .filmsApi
            .getList()
    }
}
