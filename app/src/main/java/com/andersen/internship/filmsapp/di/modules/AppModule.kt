package com.andersen.internship.filmsapp.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (private val context: Context){

    @Provides
    @Singleton
    fun context() = context
}