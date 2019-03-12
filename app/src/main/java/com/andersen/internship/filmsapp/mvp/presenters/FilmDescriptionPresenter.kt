package com.andersen.internship.filmsapp.mvp.presenters

import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmDescription
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewListFilms
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class FilmDescriptionPresenter @Inject constructor(private val modelFilmsRepository: ModelFilmsRepository): MvpPresenter<ViewFilmDescription>(){
}