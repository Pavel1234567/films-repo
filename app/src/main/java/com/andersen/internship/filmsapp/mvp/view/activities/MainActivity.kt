package com.andersen.internship.filmsapp.mvp.view.activities

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import android.widget.Toast
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
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.Spinner
import com.andersen.internship.filmsapp.pojo.films.Film
import android.widget.ArrayAdapter
import com.andersen.internship.filmsapp.R


class MainActivity : BaseAppCompatActivity(), ViewListFilms {
    override fun getContentLayoutId() = com.andersen.internship.filmsapp.R.layout.activity_main

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

        initSearchView(menu)
        initSpinner(menu)
        return true
    }

    private fun initSearchView(menu: Menu?){
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String): Boolean {
                filmsPresenter.search(newText)
                return false
            }

        })

    }

    private fun initSpinner(menu: Menu?){
        val spinnerItem = menu?.findItem(R.id.spinner)
        val spinner = spinnerItem?.actionView as Spinner

        val adapter = ArrayAdapter.createFromResource(this,
                R.array.filter_items, R.layout.spinner_view
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, itemSelected: View?, selectedItemPosition: Int, selectedId: Long) {
                when(selectedItemPosition){
                    0 -> filmsPresenter.selectedParameter = Film::year.name
                    1 -> filmsPresenter.selectedParameter = Film::country.name
                    2 -> filmsPresenter.selectedParameter = Film::genre.name
                }
            }

        }

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
        adapter.visibleListFilms = list
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
