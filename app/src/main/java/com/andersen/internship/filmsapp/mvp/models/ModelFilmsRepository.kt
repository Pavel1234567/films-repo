package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.database.DaoFilms
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi, daoFilms: DaoFilms): ModelFilmsInterface {

    private var listFilms: ListFilms? = null

    override fun loadFilms(): Observable<ListFilms> {
        if (listFilms == null){
            Timber.tag("myLogs").d("listFilms == null")

            return filmsApi.getList().doOnNext{list -> listFilms = list}
        }
        else{
            Timber.tag("myLogs").d("Observable.just")

            return Observable.just(listFilms)
        }
    }
}
