package com.andersen.internship.filmsapp.mvp.presenters

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmDescription
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FilmDescriptionPresenter @Inject constructor(
    private val modelFilmsInterface: ModelFilmsInterface,
    private val selectedItemId: Int
): BasePresenter<ViewFilmDescription>(){

    override fun onFirstViewAttach() {

        super.onFirstViewAttach()
        Timber.tag("myLog").d("onFirstViewAttach")
        downloadDescription()
    }

    private fun downloadDescription(){
        compositeDisposable = CompositeDisposable()

        val disposable = modelFilmsInterface
                .loadFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list ->
                    val description = list.single { it.id == selectedItemId }
                    viewState.showDescription(description)
                }

        compositeDisposable.add(disposable)
    }
}