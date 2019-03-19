package com.andersen.internship.filmsapp.pojo.films

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class FilmEntity(val film: Film) {

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
}