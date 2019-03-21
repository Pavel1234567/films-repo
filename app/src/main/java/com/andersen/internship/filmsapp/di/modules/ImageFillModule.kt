package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.di.scopes.BaseActivityScope
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module
class ImageFillModule {

    @BaseActivityScope
    @Provides
    fun picasso() = Picasso.get()
}