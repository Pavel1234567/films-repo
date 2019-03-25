package com.andersen.internship.filmsapp.pojo.films

data class Film(
        var id: Int = 0,
        var title: String = "",
        var image: String = "",
        var year: Int = 0,
        var country: List<String> = listOf(),
        var genre: List<String> = listOf(),
        var description: String = ""
)
