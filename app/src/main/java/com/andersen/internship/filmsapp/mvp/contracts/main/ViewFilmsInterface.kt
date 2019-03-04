package com.andersen.internship.filmsapp.mvp.contracts.main

import android.provider.ContactsContract
import com.andersen.internship.filmsapp.pojo.films.ListFilms
import com.arellomobile.mvp.MvpView

interface ViewFilmsInterface : MvpView{

    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun showFilms(list: ListFilms)

}