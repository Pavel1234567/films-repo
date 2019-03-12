package com.andersen.internship.filmsapp.mvp.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.di.modules.MainActivityModule.Companion.ITEM_POSITION
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmDescription
import com.andersen.internship.filmsapp.pojo.films.FilmDescription
import kotlinx.android.synthetic.main.activity_description.*
import timber.log.Timber
import java.io.File

class DescriptionActivity : BaseAppCompatActivity(), ViewFilmDescription {


    override fun showLoading() {
        //TODO: To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        //TODO To change body of created functions use File | Settings | File Templates.
    }

    override fun showDescription(description: FilmDescription) {
        //TODO To change body of created functions use File | Settings | File Templates.
    }

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, R.layout.activity_description)

        val position = intent.getIntExtra(ITEM_POSITION, -1)
        textView.setText("$position")
    }

}
