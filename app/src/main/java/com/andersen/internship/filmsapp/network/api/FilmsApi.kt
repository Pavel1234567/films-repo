package com.andersen.internship.filmsapp.network.api

import com.andersen.internship.filmsapp.pojo.films.ListFilms
import io.reactivex.Single
import retrofit2.http.GET


interface FilmsApi {

    @GET("films.json")
    fun getFilmsList() : Single<ListFilms>
}