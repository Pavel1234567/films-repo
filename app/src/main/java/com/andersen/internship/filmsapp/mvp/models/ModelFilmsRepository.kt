package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class ModelFilmsRepository @Inject constructor(private val filmsApi: FilmsApi): ModelFilmsInterface {

    private var listFilms: ListFilms? = null
    
    override fun loadFilms(): Observable<ListFilms> {
        Timber.tag("myLogs").d("loadFilms")
        if (listFilms == null){
            return filmsApi.getList().doOnNext{list -> listFilms = list}
        }
        else return Observable.just(listFilms)
    }
}
