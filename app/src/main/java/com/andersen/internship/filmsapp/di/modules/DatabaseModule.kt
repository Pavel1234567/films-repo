package com.andersen.internship.filmsapp.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.andersen.internship.filmsapp.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun database(applicationContext: Context) = Room.databaseBuilder(applicationContext, AppDatabase::class.java, DB_NAME).build()

    companion object {
        val DB_NAME = "FILM_DATABASE"
    }
}