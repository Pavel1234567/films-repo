package com.andersen.internship.filmsapp.mvp.contracts.main

import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListMedia
import com.arellomobile.mvp.MvpView

interface ViewFilmsInterface : MvpView {

    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun showFilms(list: List<Film>)

}