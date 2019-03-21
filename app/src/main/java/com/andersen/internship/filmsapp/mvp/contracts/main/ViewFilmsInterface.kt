package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.FilmDTO
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ViewFilmsInterface : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showLoading()

    @StateStrategyType(SkipStrategy::class)
    fun hideLoading()

    @StateStrategyType(SkipStrategy::class)
    fun showError(message: String)

    @StateStrategyType(AddToEndStrategy ::class)
    fun showFilms(list: List<FilmDTO>)

}