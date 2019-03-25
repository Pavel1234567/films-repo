package com.andersen.internship.filmsapp.database

import android.arch.persistence.room.TypeConverter

class ListStringsConverter {

    @TypeConverter
    fun toStr(list: MutableList<String>) = list.joinToString(separator = ",")

    @TypeConverter
    fun toList(string: String) = string.split(",").toMutableList()
}