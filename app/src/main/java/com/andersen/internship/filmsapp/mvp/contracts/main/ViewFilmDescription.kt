package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.FilmDescription
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ViewFilmDescription :MvpView, BaseViewInterface{
    @StateStrategyType(AddToEndStrategy ::class)
    fun showDescription(description: FilmDescription)

}