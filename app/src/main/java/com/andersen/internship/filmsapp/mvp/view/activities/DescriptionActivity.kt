package com.andersen.internship.filmsapp.mvp.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.di.modules.DescriptionActivityModule
import com.andersen.internship.filmsapp.loadImage
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmDescription
import com.andersen.internship.filmsapp.mvp.presenters.FilmDescriptionPresenter
import com.andersen.internship.filmsapp.pojo.films.Film
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_description.*
import javax.inject.Inject

class DescriptionActivity : BaseAppCompatActivity(), ViewFilmDescription {

    @Inject
    @InjectPresenter
    lateinit var filmDescriptionPresenter: FilmDescriptionPresenter

    @ProvidePresenter
    fun providePresenter() = filmDescriptionPresenter

    override fun showDescription(film: Film) {

        imageView.loadImage(film.image)
        countryTextView.text = film.country.joinToString()
        titleTextView.text = film.title
        yearTextView.text = "${film.year}"
        genreTextView.text = film.genre.joinToString()
        descriptionTextView.text = film.description
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {


        baseActivityComponent
            .descriptionActivityComponent(DescriptionActivityModule(this))
            .injectDescriptionActivity(this)


        super.onCreate(savedInstanceState, R.layout.activity_description)

    }
}
