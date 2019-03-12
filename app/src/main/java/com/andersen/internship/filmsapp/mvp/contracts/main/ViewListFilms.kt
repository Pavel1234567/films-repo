package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.Film
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ViewListFilms : MvpView, BaseViewInterface {
    @StateStrategyType(AddToEndStrategy ::class)
    fun showFilms(list: List<Film>)
}