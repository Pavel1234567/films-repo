package com.andersen.internship.filmsapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(FilmEntity::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun filmDao(): DaoFilms
}