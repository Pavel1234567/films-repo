package com.andersen.internship.filmsapp.mvp.view.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.andersen.internship.filmsapp.App
import com.andersen.internship.filmsapp.di.modules.BaseActivityModule
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmsInterface
import com.arellomobile.mvp.MvpAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*
import timber.log.Timber

abstract class BaseAppCompatActivity : MvpAppCompatActivity(), ViewFilmsInterface {

    protected val baseActivityComponent by lazy {
        App.get(this)
            .appComponent
            .baseActivityComponent(BaseActivityModule())
    }

    protected fun onCreate(savedInstanceState: Bundle?, layoutId: Int) {

        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setSupportActionBar(toolbar)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
