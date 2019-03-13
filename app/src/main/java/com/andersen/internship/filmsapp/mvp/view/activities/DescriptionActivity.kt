package com.andersen.internship.filmsapp.mvp.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.andersen.internship.filmsapp.App
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.di.components.DaggerDescriptionActivityComponent
import com.andersen.internship.filmsapp.di.modules.DescriptionActivityModule
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmDescription
import com.andersen.internship.filmsapp.mvp.presenters.FilmDescriptionPresenter
import com.andersen.internship.filmsapp.pojo.films.Film
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*
import javax.inject.Inject

class DescriptionActivity : BaseAppCompatActivity(), ViewFilmDescription {

    @Inject
    @InjectPresenter
    lateinit var filmDescriptionPresenter: FilmDescriptionPresenter

    @ProvidePresenter
    fun providePresenter() = filmDescriptionPresenter

    override fun showDescription(film: Film) {

        //TODO список без скобок

        Picasso.get()
                .load(film.image)
                .into(imageView)
        countryTextView.setText(film.country.toString())

        titleTextView.text = film.title
        yearTextView.text = "${film.year}"
        genreTextView.text = film.genre.toString()
        descriptionTextView.text = film.description
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {

        val descriptionActivityComponent = DaggerDescriptionActivityComponent
                .builder()
                .descriptionActivityModule(DescriptionActivityModule(this))
                .appComponent(App.get(this).appComponent)
                .build()

        descriptionActivityComponent.injectDescriptionActivity(this)

        super.onCreate(savedInstanceState, R.layout.activity_description)

    }
}
