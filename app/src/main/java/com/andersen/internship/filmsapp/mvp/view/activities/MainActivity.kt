package com.andersen.internship.filmsapp.mvp.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.component
import com.andersen.internship.filmsapp.di.components.DaggerMainActivityComponent
import com.andersen.internship.filmsapp.di.modules.MainActivityModule
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.ui.adapters.FilmItemAdapter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber
import javax.inject.Inject


class MainActivity : BaseAppCompatActivity() {

    private val mainActivityComponent = DaggerMainActivityComponent
        .builder()
        .mainActivityModule(MainActivityModule())
        .appComponent(component)
        .build()

    @Inject
    @InjectPresenter
    lateinit var filmsPresenter: FilmsPresenter

    @ProvidePresenter
    fun providePresenter() = filmsPresenter

    private val adapter = FilmItemAdapter(this)

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {

        onCreate(savedInstanceState, R.layout.activity_main)
        mainActivityComponent.injectMainActivity(this)
        initRecyclerView()
        Timber.tag("myLogs").d("MainActivity filmsPresenter ${filmsPresenter.hashCode()}")
        Timber.tag("myLogs").d("MainActivity modelFilmsRepository ${filmsPresenter.modelFilmsRepository.hashCode()}")
        Timber.tag("myLogs").d("MainActivity networkService ${filmsPresenter.modelFilmsRepository.networkService.hashCode()}")
    }

    private fun initRecyclerView() {

        val calculator = FilmItemAdapter.SizeCalculator(this)
        val spanCount = calculator.calculateSpanCount()
        val gridLayoutManager = GridLayoutManager(this, spanCount)
        recyclerView.layoutManager = gridLayoutManager as RecyclerView.LayoutManager?
        recyclerView.adapter = adapter
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

    override fun showFilms(list: List<Film>) {

        Timber.tag("myLogs").d("showFilms")
        recyclerView.visibility = View.VISIBLE
        adapter.listFilms = list
    }
}
