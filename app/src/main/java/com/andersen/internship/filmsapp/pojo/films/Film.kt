package com.andersen.internship.filmsapp.pojo.films


class Film {

    private var id: Int = 0

    var title: String? = null

    var image: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id!!
    }

}
