package com.andersen.internship.filmsapp

import com.andersen.internship.filmsapp.pojo.films.ListMedia

object Cache {

    val map = mutableMapOf<MediaItems, ListMedia>()
}

enum class MediaItems{
    Films
}