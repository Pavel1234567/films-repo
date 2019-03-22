package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.network.api.FilmsApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun filmsApi(retrofit: Retrofit) = retrofit.create(FilmsApi::class.java)

    @Singleton
    @Provides
    fun retrofit(gson: Gson) = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Singleton
    @Provides
    fun gson() = GsonBuilder().create()

    companion object {
        private val BASE_URL = "https://gist.github.com/giffell/d95a42738dd91feefb28d9947f8d4fff/raw/3bbb3933cdfc1513e602dbffc83bbc401236f71f/"
    }
}