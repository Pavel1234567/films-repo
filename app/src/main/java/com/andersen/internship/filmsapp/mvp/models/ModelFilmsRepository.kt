package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.database.DaoFilms
import com.andersen.internship.filmsapp.database.FilmEntity
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher
import timber.log.Timber
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi, private val daoFilms: DaoFilms) :
    ModelFilmsInterface {

    override fun loadFilms(): Single<ListFilms> {

        return daoFilms
            .getList()
            .flatMap { list ->
                if (list.isEmpty()) {
                    return@flatMap filmsApi
                        .getList()
                        .doOnSuccess {val listForDB = it.films.map {
                            FilmEntity(it)
                        }
                            daoFilms.insert(listForDB)  }
                } else {
                    return@flatMap Single.just(list).map { ListFilms(it.map { it.film }) }
                }
            }

    }
}