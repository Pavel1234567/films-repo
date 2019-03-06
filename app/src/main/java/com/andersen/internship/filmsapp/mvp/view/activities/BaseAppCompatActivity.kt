package com.andersen.internship.filmsapp.mvp.view.activities

import android.os.Bundle
import android.widget.Toast
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmsInterface
import com.arellomobile.mvp.MvpAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*
import timber.log.Timber

abstract class BaseAppCompatActivity: MvpAppCompatActivity(), ViewFilmsInterface {

    protected fun onCreate(savedInstanceState: Bundle?, layoutId: Int){
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setSupportActionBar(toolbar)

    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Timber.tag("myLogs").d(message)
    }
}