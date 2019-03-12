package com.andersen.internship.filmsapp.mvp.view.activities

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmDescription
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.FilmDescription
import timber.log.Timber

class DescriptionActivity : BaseAppCompatActivity(), ViewFilmDescription {


    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDescription(description: FilmDescription) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, R.layout.activity_detail)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Timber.tag("myLogs").d(message)
    }
}
