package com.andersen.internship.filmsapp.mvp.contracts.main

import android.support.design.circularreveal.CircularRevealHelper
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListMedia
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ViewFilmsInterface : MvpView {

    @StateStrategyType(value = SkipStrategy::class)
    fun showLoading()

    @StateStrategyType(value = SkipStrategy::class)
    fun hideLoading()

    @StateStrategyType(value = SkipStrategy::class)
    fun showError(message: String)

    fun showFilms(list: List<Film>)

}