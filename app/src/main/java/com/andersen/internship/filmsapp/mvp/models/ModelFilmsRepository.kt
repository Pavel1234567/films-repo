package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Single
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi): ModelFilmsInterface {

    override fun loadFilms(): Single<ListFilms> = filmsApi.getFilmsList()
}
