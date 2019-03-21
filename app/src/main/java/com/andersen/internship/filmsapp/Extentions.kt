package com.andersen.internship.filmsapp

import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject


fun ImageView.setImage(uri: String){
   Picasso.get().load(uri)
            .into(this)
}
