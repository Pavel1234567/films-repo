package com.andersen.internship.filmsapp.mvp.presenters

import android.view.View
import com.andersen.internship.filmsapp.mvp.contracts.main.BaseViewInterface
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T: BaseViewInterface>: MvpPresenter<T>() {
    protected var compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

}