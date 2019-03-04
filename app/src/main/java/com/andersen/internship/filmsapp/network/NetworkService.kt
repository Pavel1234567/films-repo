package com.andersen.internship.filmsapp.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    val retrofit: Retrofit

    init {
        val gsonBuilder = GsonBuilder()

        val gson = gsonBuilder.create()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    }
}

private val BASE_URL = "https://gist.github.com/giffell/"