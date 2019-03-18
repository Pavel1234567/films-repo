package com.andersen.internship.filmsapp.di.modules

import android.content.Context
import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.scopes.BaseActivityScope
import com.andersen.internship.filmsapp.get
import com.andersen.internship.filmsapp.mvp.view.activities.BaseAppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class BaseActivityModule {

    @BaseActivityScope
    @Provides
    fun sizeCalculator(context: Context) = SizeCalculator(context.resources)
}