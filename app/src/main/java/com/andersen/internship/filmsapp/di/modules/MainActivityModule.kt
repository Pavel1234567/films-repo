package com.andersen.internship.filmsapp.di.modules

import android.content.Intent
import android.widget.Toast
import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.scopes.MainActivityScope
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import com.andersen.internship.filmsapp.ui.adapters.FilmItemAdapter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val mainActivity: MainActivity) {


    @MainActivityScope
    @Provides
    fun sizeCalculator() = SizeCalculator(mainActivity)

    @MainActivityScope
    @Provides
    fun filmItemAdapter(sizeCalculator: SizeCalculator, onItemClickListener: FilmItemAdapter.OnItemClickListener
    ): FilmItemAdapter =
         FilmItemAdapter(sizeCalculator.calculateWidthAndHeightOfView(), onItemClickListener)

    @MainActivityScope
    @Provides
    fun onItemClickListener(): FilmItemAdapter.OnItemClickListener{
        val onItemClickListener = object : FilmItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {

                Toast.makeText(mainActivity, "$position", Toast.LENGTH_LONG).show()
            }
        }
        return onItemClickListener
    }

    @MainActivityScope
    @Provides
    fun provideMainPresenter(modelFilmsRepository: ModelFilmsRepository): FilmsPresenter =
        FilmsPresenter(modelFilmsRepository)

}