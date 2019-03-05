package com.andersen.internship.filmsapp.ui.activities

import android.app.ProgressDialog
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
import android.graphics.Point
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast


class MainActivity : MvpAppCompatActivity(), ViewFilmsInterface {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    private val adapter = FilmItemAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.andersen.internship.filmsapp.R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            mainPresenter.downloadList()
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x

        var spanCount: Int = width/256

        if(spanCount < 2) spanCount = 2
        else if(spanCount > 4) spanCount = 4

        val gridLayoutManager = GridLayoutManager(this, spanCount)
        recyclerView.layoutManager = gridLayoutManager as RecyclerView.LayoutManager?
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(com.andersen.internship.filmsapp.R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            com.andersen.internship.filmsapp.R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
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

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Timber.tag("myLogs").d(message)
    }

    override fun showFilms(list: List<Film>) {
        recyclerView.visibility = View.VISIBLE
        adapter.listFilms = list
    }
}
