package com.andersen.internship.filmsapp.mvp.contracts.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseViewInterface : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showLoading()

    @StateStrategyType(SkipStrategy::class)
    fun hideLoading()

    @StateStrategyType(SkipStrategy::class)
    fun showError(message: String)

}