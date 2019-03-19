package com.andersen.internship.filmsapp.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.andersen.internship.filmsapp.pojo.films.Film
import io.reactivex.Flowable

@Dao
interface DaoFilms {

    @Query("SELECT * FROM filmentity")
    fun getList() : Flowable<List<FilmEntity>>

    @Query("SELECT * FROM filmEntity WHERE id = :id")
    fun getFilmById(id: Int): Flowable<Film>

    @Insert
    fun insert(list: List<FilmEntity>)
}