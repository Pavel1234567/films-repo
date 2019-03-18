package com.andersen.internship.filmsapp

import android.content.res.Resources
import javax.inject.Inject
import kotlin.math.roundToInt

class SizeCalculator @Inject constructor(private val resources: Resources){

    var widthScreen: Int = resources.displayMetrics.widthPixels

    fun calculateWidthAndHeightOfView(): Pair<Int, Int>{

        val recyclerViewMargin = resources.getDimensionPixelSize(R.dimen.recycler_view_margin)
        val linearLayoutPadding = resources.getDimensionPixelSize(R.dimen.linear_layout_padding)
        val cardViewLayoutMargin = resources.getDimensionPixelSize(R.dimen.card_view_layout_margin)
        val spanCount = calculateSpanCount()

        val widthImage = (widthScreen - 2 * (recyclerViewMargin - spanCount * (linearLayoutPadding - cardViewLayoutMargin)))/spanCount
        val heightImage = widthImage * HEIGHT_WIDTH_RELATION

        return Pair(widthImage, heightImage.roundToInt())
    }

    fun calculateSpanCount(): Int{

        var spanCount: Int = widthScreen/ IMAGE_VIEW_APPROXIMATE_WIDTH
        if(spanCount < MIN_SPAN_COUNT) spanCount = MIN_SPAN_COUNT
        return spanCount
    }

    companion object {

        private val IMAGE_VIEW_APPROXIMATE_WIDTH = 256
        private val MIN_SPAN_COUNT = 2
        private val HEIGHT_WIDTH_RELATION = 1.5
    }
}


