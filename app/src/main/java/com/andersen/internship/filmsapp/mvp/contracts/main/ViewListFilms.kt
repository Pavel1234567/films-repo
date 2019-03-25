package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.FilmDTO
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ViewListFilms : BaseViewInterface {
    @StateStrategyType(AddToEndStrategy ::class)
    fun showFilms(list: List<FilmDTO>)
}