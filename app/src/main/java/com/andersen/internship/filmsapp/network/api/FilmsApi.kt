package com.andersen.internship.filmsapp.network.api

import com.andersen.internship.filmsapp.pojo.films.FilmDescription
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Query


interface FilmsApi {

    @GET("films.json")
    fun getList() : Observable<ListFilms>

    @GET("films.json/films/{id}")
    fun getDescription(@Query("id")id: Int): Observable<FilmDescription>
}