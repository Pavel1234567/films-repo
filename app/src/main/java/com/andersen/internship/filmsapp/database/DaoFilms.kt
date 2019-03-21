package com.andersen.internship.filmsapp.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface DaoFilms {

    @Query("SELECT * FROM filmentity")
    fun getList() : Single<List<FilmEntity>>

    @Query("SELECT * FROM filmEntity WHERE id = :id")
    fun getFilmById(id: Int): Single<FilmEntity>

    @Insert
    fun insert(list: List<FilmEntity>)
}