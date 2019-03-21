package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi): ModelFilmsInterface {

    override fun loadFilms(): Observable<ListFilms> = filmsApi.getFilmsList()
}
