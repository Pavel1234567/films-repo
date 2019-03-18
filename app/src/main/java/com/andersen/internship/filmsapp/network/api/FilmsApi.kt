package com.andersen.internship.filmsapp.network.api

import com.andersen.internship.filmsapp.pojo.films.ListMedia
import io.reactivex.Observable
import retrofit2.http.GET


interface FilmsApi {

    @GET("d95a42738dd91feefb28d9947f8d4fff/raw/3bbb3933cdfc1513e602dbffc83bbc401236f71f/films.json")
    fun getFilmsList() : Observable<ListMedia>
}