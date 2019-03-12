package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.Film
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ViewFilmDescription :BaseViewInterface{
    @StateStrategyType(AddToEndStrategy ::class)
    fun showDescription(description: Film)

}