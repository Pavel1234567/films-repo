package com.andersen.internship.filmsapp.mvp.view.activities

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.andersen.internship.filmsapp.di.components.DaggerMainActivityComponent
import com.andersen.internship.filmsapp.mvp.presenters.MainPresenter
import com.andersen.internship.filmsapp.pojo.films.Film
import com.andersen.internship.filmsapp.ui.adapters.FilmItemAdapter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber
import javax.inject.Inject


class MainActivity : BaseAppCompatActivity() {

    private val mainActivityComponent = DaggerMainActivityComponent.create()

    @Inject
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = mainActivityComponent.injectMainActivity(this)

    private val adapter = FilmItemAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(com.andersen.internship.filmsapp.R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {

        val calculator = FilmItemAdapter.SizeCalculator(this)
        val spanCount = calculator.calculateSpanCount()
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

    override fun showFilms(list: List<Film>) {
        Timber.tag("myLogs").d("showFilms")

        recyclerView.visibility = View.VISIBLE
        adapter.listFilms = list
    }
}
