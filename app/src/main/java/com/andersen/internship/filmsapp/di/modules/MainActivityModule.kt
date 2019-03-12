package com.andersen.internship.filmsapp.di.modules

import android.content.Intent
import android.widget.Toast
import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.scopes.MainActivityScope
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.mvp.view.activities.DescriptionActivity
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
    fun widthAndHeightOfImageView(sizeCalculator: SizeCalculator) = sizeCalculator.calculateWidthAndHeightOfView()

    @MainActivityScope
    @Provides
    fun onItemClickListener(): FilmItemAdapter.OnItemClickListener{
        val onItemClickListener = object : FilmItemAdapter.OnItemClickListener {
            override fun onItemClick(id: Int) {
                val intent = Intent(mainActivity, DescriptionActivity::class.java)
                intent.putExtra(ITEM_POSITION, id)
                mainActivity.startActivity(intent)
            }
        }
        return onItemClickListener
    }

    @MainActivityScope
    @Provides
    fun provideMainPresenter(modelFilmsRepository: ModelFilmsRepository): FilmsPresenter =
        FilmsPresenter(modelFilmsRepository)

    companion object {
        val ITEM_POSITION = "ITEM_POSITION"
    }
}