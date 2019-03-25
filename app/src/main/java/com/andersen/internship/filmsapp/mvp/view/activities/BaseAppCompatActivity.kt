package com.andersen.internship.filmsapp.mvp.view.activities

import android.os.Bundle
import com.andersen.internship.filmsapp.App
import com.andersen.internship.filmsapp.di.modules.BaseActivityModule
import com.arellomobile.mvp.MvpAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseAppCompatActivity : MvpAppCompatActivity() {

    protected val baseActivityComponent by lazy {
        App.get(this)
            .appComponent
            .baseActivityComponent(BaseActivityModule())
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(getContentLayoutId())
        setSupportActionBar(toolbar)
    }

    abstract fun getContentLayoutId(): Int
}
