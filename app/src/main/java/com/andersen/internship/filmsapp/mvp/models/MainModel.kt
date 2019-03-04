package com.andersen.internship.filmsapp.mvp.models

import com.andersen.internship.filmsapp.Cache
import com.andersen.internship.filmsapp.MediaItems
import com.andersen.internship.filmsapp.component
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.network.NetworkService
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListMedia
import io.reactivex.Observable
import javax.inject.Inject

class MainModel: ModelFilmsInterface {

    @Inject
    lateinit var networkService: NetworkService

    init {
        component.injectNetworkService(this)
    }

    override fun loadFilms(): Observable<ListMedia> {

        val observable: Observable<ListMedia>
        if (!cache.map.containsKey(MediaItems.Films)){
            observable = networkService
                .filmsApi
                .getList()
                .doOnNext { list -> cache.map.put(MediaItems.Films, list) }
        }else{
            observable = Observable.just(cache.map[MediaItems.Films])
        }
        return observable
    }
}
private val cache = Cache