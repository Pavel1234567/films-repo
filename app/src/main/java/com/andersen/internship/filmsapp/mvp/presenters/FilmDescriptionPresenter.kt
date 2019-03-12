package com.andersen.internship.filmsapp.mvp.presenters

import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmDescription
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FilmDescriptionPresenter @Inject constructor(
        private val modelFilmsRepository: ModelFilmsRepository,
        private val selectedItemId: Int
): BasePresenter<ViewFilmDescription>(){

    override fun onFirstViewAttach() {

        super.onFirstViewAttach()
        Timber.tag("myLog").d("onFirstViewAttach")
        downloadDescription()
    }

    private fun downloadDescription(){
        viewState.showLoading()
        compositeDisposable = CompositeDisposable()

        val disposable = modelFilmsRepository
                .loadFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list ->
                            val description = list.films.single { it.id == selectedItemId }
                            viewState.showDescription(description) },
                        { e ->
                            viewState.hideLoading()
                            e.message?.let { viewState.showError(it) }
                        },
                        {viewState.hideLoading()})

        compositeDisposable.add(disposable)
    }
}