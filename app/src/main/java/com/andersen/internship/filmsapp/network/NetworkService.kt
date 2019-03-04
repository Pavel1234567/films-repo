package com.andersen.internship.filmsapp.network

import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    val filmsApi: FilmsApi

    init {
        val retrofit: Retrofit

        val gsonBuilder = GsonBuilder()

        val gson = gsonBuilder.create()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        filmsApi = retrofit.create(FilmsApi::class.java)

    }
}

private val BASE_URL = "https://gist.github.com/giffell/"