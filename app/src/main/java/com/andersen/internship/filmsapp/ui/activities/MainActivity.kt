package com.andersen.internship.filmsapp.ui.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.andersen.internship.filmsapp.R
import com.andersen.internship.filmsapp.mvp.contracts.main.ViewFilmsInterface
import com.andersen.internship.filmsapp.mvp.presenters.MainPresenter
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.pojo.films.ListMedia
import com.andersen.internship.filmsapp.ui.adapters.FilmItemAdapter
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber

class MainActivity : MvpAppCompatActivity(), ViewFilmsInterface {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    private val adapter = FilmItemAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            mainPresenter.downloadList()
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {

        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showLoading() {
        Timber.tag("myLogs").d("showLoading")

    }

    override fun hideLoading() {
        Timber.tag("myLogs").d("hideLoading")

    }

    override fun showError(message: String) {
        Timber.tag("myLogs").d(message)

    }

    override fun showFilms(list: List<Film>) {
        adapter.listFilms = list
    }
}
