package com.andersen.internship.filmsapp.mvp.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.modules.MainActivityModule
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewListFilms
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.pojo.films.FilmDTO
import com.andersen.internship.filmsapp.ui.adapters.FilmItemAdapter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber
import javax.inject.Inject


class MainActivity : BaseAppCompatActivity(), ViewListFilms {

    @Inject
    @InjectPresenter
    lateinit var filmsPresenter: FilmsPresenter

    @ProvidePresenter
    fun providePresenter() = filmsPresenter

    @Inject
    lateinit var sizeCalculator: SizeCalculator

    @Inject
    lateinit var adapter: FilmItemAdapter

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {

        baseActivityComponent
            .mainActivityComponent(MainActivityModule(this))
            .injectMainActivity(this)

        onCreate(savedInstanceState, R.layout.activity_main)

        initRecyclerView()
        Timber.tag("myLogs").d("MainActivity filmsPresenter ${filmsPresenter.hashCode()}")
    }

    private fun initRecyclerView() {

        val spanCount = sizeCalculator.calculateSpanCount()
        val gridLayoutManager = GridLayoutManager(this, spanCount)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = gridLayoutManager
    }

    override fun showLoading() {

        recyclerView.visibility = View.GONE
        progressbar.visibility = View.VISIBLE
        Timber.tag("myLogs").d("showLoading")
    }

    override fun hideLoading() {
        progressbar.visibility = View.GONE
        Timber.tag("myLogs").d("hideLoading")
    }

    override fun showFilms(list: List<FilmDTO>) {

        Timber.tag("myLogs").d("showFilms")
        recyclerView.visibility = View.VISIBLE
        adapter.listFilms = list
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Timber.tag("myLogs").d(message)
    }

}
