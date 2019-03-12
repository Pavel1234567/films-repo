package com.andersen.internship.filmsapp.pojo.films

data class FilmDescription(
    val title: String,
    val image: String,
    val year: Int,
    val country: List<String>,
    val genre: List<String>,
    val description: String
)