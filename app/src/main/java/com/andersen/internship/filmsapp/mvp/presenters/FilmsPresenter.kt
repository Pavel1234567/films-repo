package com.andersen.internship.filmsapp.mvp.presenters

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilter
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewListFilms
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.FilmDTO
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class FilmsPresenter @Inject constructor(
        private val modelFilmsInterface: ModelFilmsInterface,
        private val filterFilms: ModelFilter): BasePresenter<ViewListFilms>() {

    var selectedParameter:String = Film::genre.name


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
                    filterFilms.fullListFilms = list
                },
                { e ->
                    viewState.hideLoading()
                    e.message?.let { viewState.showError(it) }
                })

        compositeDisposable.add(disposable)
    }

    fun search(inputText: String){

        val disposable = filterFilms.search(inputText, selectedParameter).subscribe(
                { list ->
                    val handledList: List<FilmDTO> = list.map { FilmDTO(it.id, it.title, it.image) }
                    viewState.showFilms(handledList)
                },
                { e ->
                    viewState.hideLoading()
                    e.message?.let { viewState.showError(it) }
                }
        )
        compositeDisposable.add(disposable)
    }
}