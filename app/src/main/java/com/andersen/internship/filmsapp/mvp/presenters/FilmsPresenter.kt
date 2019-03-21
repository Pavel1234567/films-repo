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
        compositeDisposable = CompositeDisposable()

        val disposable = modelFilmsInterface
            .loadFilms()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    val handledList: List<FilmDTO> = list.films.map { FilmDTO(it.id, it.title, it.image) }
                    viewState.showFilms(handledList)
                },
                { e ->
                    viewState.hideLoading()
                    e.message?.let { viewState.showError(it) }
                },
                {viewState.hideLoading()})

        compositeDisposable.add(disposable)
    }
}