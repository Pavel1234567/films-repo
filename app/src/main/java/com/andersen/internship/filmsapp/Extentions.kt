package com.andersen.internship.filmsapp

import android.widget.ImageView
import com.squareup.picasso.Picasso


fun ImageView.loadImage(uri: String){
   Picasso.get().load(uri)
            .into(this)
}
