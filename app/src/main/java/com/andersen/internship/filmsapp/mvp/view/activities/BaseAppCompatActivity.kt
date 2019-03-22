package com.andersen.internship.filmsapp.mvp.view.activities

import android.os.Bundle
import com.andersen.internship.filmsapp.App
import com.andersen.internship.filmsapp.di.modules.BaseActivityModule
import android.widget.Toast
import com.andersen.internship.filmsapp.mvp.contracts.main.BaseViewInterface
import com.arellomobile.mvp.MvpAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseAppCompatActivity: MvpAppCompatActivity() {

    protected val baseActivityComponent by lazy {
        App.get(this)
            .appComponent
            .baseActivityComponent(BaseActivityModule())
    }

    protected fun onCreate(savedInstanceState: Bundle?, layoutId: Int){

        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setSupportActionBar(toolbar)
    }
}