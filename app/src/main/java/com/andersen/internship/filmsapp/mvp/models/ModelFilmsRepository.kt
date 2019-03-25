package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Single
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi): ModelFilmsInterface {

    private var listFilms: List<Film> = listOf()

    override fun loadFilms(): Single<List<Film>> {
        return if (listFilms.isEmpty()){
            filmsApi.getFilmsList().map { it.films }.doOnSuccess{list -> listFilms = list}
        } else{
            Single.just(listFilms)
        }
    }
}
