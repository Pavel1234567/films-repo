package com.andersen.internship.filmsapp.mvp.presenters

import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmsInterface
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MainPresenter: MvpPresenter<ViewFilmsInterface>() {


    fun downloadList(){
        viewState.showLoading()
    }

    fun onListItemClicked(item: Int){

    }
}