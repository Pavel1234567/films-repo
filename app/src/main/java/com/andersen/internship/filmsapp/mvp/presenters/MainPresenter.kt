package com.andersen.internship.filmsapp.mvp.presenters

import com.andersen.internship.filmsapp.component
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmsInterface
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class MainPresenter: MvpPresenter<ViewFilmsInterface>() {

    private var compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var modelFilmsInterface: ModelFilmsInterface

    init {
        component.injectMainModel(this)
    }

    fun downloadList(){
        viewState.showLoading()
        if (compositeDisposable.size() > 0) {
            compositeDisposable.dispose()
            compositeDisposable = CompositeDisposable()
        }
        val disposable = modelFilmsInterface
            .loadFilms()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list -> viewState.showFilms(list.films) },
                { e ->
                    viewState.hideLoading()
                    e.message?.let { viewState.showError(it) }
                },
                {viewState.hideLoading()})

        compositeDisposable.add(disposable)
    }

    fun onListItemClicked(item: Int){

    }
}