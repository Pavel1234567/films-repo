package com.andersen.internship.filmsapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.andersen.internship.filmsapp.database.AppDatabase.Companion.VERSION_CODE

@Database(entities = arrayOf(FilmEntity::class), version = VERSION_CODE)
abstract class AppDatabase: RoomDatabase() {
    abstract fun filmDao(): DaoFilms

    companion object {
        const val VERSION_CODE = 1
    }
}