package com.andersen.internship.filmsapp.mvp.presenters

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmsInterface
import com.andersen.internship.filmsapp.pojo.films.FilmDTO
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FilmsPresenter @Inject constructor(private val modelFilmsInterface: ModelFilmsInterface): BasePresenter<ViewFilmsInterface>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        downloadList()
    }

    private fun downloadList(){
        viewState.showLoading()

        val disposable = modelFilmsInterface
            .loadFilms()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    val handledList: List<FilmDTO> = list.map { FilmDTO(it.id, it.title, it.image) }
                    viewState.showFilms(handledList)
                    viewState.hideLoading()
                },
                { e ->
                    viewState.hideLoading()
                    e.message?.let { viewState.showError(it) }
                })

        compositeDisposable.add(disposable)
    }
}