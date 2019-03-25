package com.andersen.internship.filmsapp.database

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.andersen.internship.filmsapp.pojo.films.Film

@Entity
@TypeConverters(ListStringsConverter::class)
data class FilmEntity( @Embedded var film: Film){

    @field:PrimaryKey(autoGenerate = true) var idEntity: Int = 0
}
