package com.andersen.internship.filmsapp.mvp.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.modules.MainActivityModule
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.pojo.films.FilmDTO
import com.andersen.internship.filmsapp.ui.adapters.FilmItemAdapter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject


class MainActivity : BaseAppCompatActivity() {

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
    }

    override fun hideLoading() {
        progressbar.visibility = View.GONE
    }

    override fun showFilms(list: List<FilmDTO>) {
        recyclerView.visibility = View.VISIBLE
        adapter.listFilms = list
    }
}
