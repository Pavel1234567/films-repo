package com.andersen.internship.filmsapp.database

import android.arch.persistence.room.Entity
import com.andersen.internship.filmsapp.pojo.films.Film
import android.arch.persistence.room.PrimaryKey

@Entity
data class FilmEntity(val film: Film){

    @PrimaryKey
    var id: Int = 0
}