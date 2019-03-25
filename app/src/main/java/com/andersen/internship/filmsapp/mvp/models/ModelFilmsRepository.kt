package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.database.DaoFilms
import com.andersen.internship.filmsapp.database.FilmEntity
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Single
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi, private val daoFilms: DaoFilms) :

    ModelFilmsInterface {
    override fun loadFilmById(id: Int): Single<Film> = daoFilms
        .getFilmById(id)
        .map { takeOffEntityShell(it) }

    override fun loadFilms(): Single<List<Film>> = daoFilms
        .getListFilms()
        .flatMap { listFilmEntity ->
            if (listFilmEntity.isEmpty()) {
                getFilmsFromNetwork()
            } else {
                getListFilmsFromDB(listFilmEntity)
            }
        }

    private fun getListFilmsFromDB(listFilmEntity: List<FilmEntity>) = Single
            .just(listFilmEntity)
            .map { it.map { takeOffEntityShell(it) } }

    private fun getFilmsFromNetwork() =
        filmsApi
            .getFilmsList()
            .map { takeOffJsonShell(it) }
            .doOnSuccess {
                writeFilmsInDB(it)
            }

    private fun writeFilmsInDB(listFilms: List<Film>){
        val listForDB = listFilms.map { FilmEntity(it) }
        daoFilms.insert(listForDB)
    }

    private fun takeOffJsonShell(listFilms: ListFilms) = listFilms.films

    private fun takeOffEntityShell(filmEntity: FilmEntity) = filmEntity.film
}
