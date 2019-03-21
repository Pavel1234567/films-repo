package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.database.DaoFilms
import com.andersen.internship.filmsapp.database.FilmEntity
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.Film
import io.reactivex.Single
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi, private val daoFilms: DaoFilms) :


    ModelFilmsInterface {
    override fun loadFilmById(id: Int): Single<Film> = daoFilms
        .getFilmById(id)
        .map { it.film }

    override fun loadFilms(): Single<List<Film>> = daoFilms
        .getList()
        .flatMap { list ->
            if (list.isEmpty()) {
                return@flatMap filmsApi
                    .getList()
                    .map { it.films }
                    .doOnSuccess {
                        val listForDB = it.map { FilmEntity(it) }
                        daoFilms.insert(listForDB)
                    }
            } else {
                return@flatMap Single.just(list).map { it.map { it.film } }
            }
        }
}