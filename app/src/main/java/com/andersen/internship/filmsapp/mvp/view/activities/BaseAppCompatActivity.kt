package com.andersen.internship.filmsapp.mvp.view.activities

import android.os.Bundle
import android.widget.Toast
import com.andersen.internship.filmsapp.mvp.contracts.main.BaseViewInterface
import com.arellomobile.mvp.MvpAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*
import timber.log.Timber

abstract class BaseAppCompatActivity: MvpAppCompatActivity() {

    protected fun onCreate(savedInstanceState: Bundle?, layoutId: Int){

        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setSupportActionBar(toolbar)

    }

}