package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Single
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi): ModelFilmsInterface {

    private var listFilms: List<Film>? = null

    override fun loadFilms(): Single<List<Film>> {
        if (listFilms == null){

            return filmsApi.getFilmsList().map { it.films }.doOnSuccess{list -> listFilms = list}
        }
        else{

            return Single.just(listFilms)
        }
    }
}
