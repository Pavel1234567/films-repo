package com.andersen.internship.filmsapp.mvp.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
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
import javax.inject.Inject


class MainActivity : BaseAppCompatActivity(), ViewListFilms {
    override fun getContentLayoutId() = R.layout.activity_main

    @Inject
    @InjectPresenter
    lateinit var filmsPresenter: FilmsPresenter

    @ProvidePresenter
    fun providePresenter() = filmsPresenter

    @Inject
    lateinit var sizeCalculator: SizeCalculator

    @Inject
    lateinit var adapter: FilmItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        baseActivityComponent
            .mainActivityComponent(MainActivityModule(this))
            .injectMainActivity(this)

        super.onCreate(savedInstanceState)
        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_for_toolbar, menu)
        return true
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

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
