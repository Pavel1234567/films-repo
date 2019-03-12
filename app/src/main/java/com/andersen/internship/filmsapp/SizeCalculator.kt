package com.andersen.internship.filmsapp

import android.app.Activity
import android.graphics.Point
import javax.inject.Inject
import kotlin.math.roundToInt

class SizeCalculator @Inject constructor(private val activity: Activity){

    private var widthScreen: Int = 0


    fun calculateWidthAndHeightOfView(): Pair<Int, Int>{

        val recyclerViewMargin = activity.resources.getDimensionPixelSize(R.dimen.recycler_view_margin)
        val linearLayoutPadding = activity.resources.getDimensionPixelSize(R.dimen.linear_layout_padding)
        val cardViewLayoutMargin = activity.resources.getDimensionPixelSize(R.dimen.card_view_layout_margin)
        val spanCount = calculateSpanCount()

        val widthImage = (calculateWidthScreen() - 2 * (recyclerViewMargin - spanCount * (linearLayoutPadding - cardViewLayoutMargin)))/spanCount
        val heightImage = widthImage * 3/2

        return Pair(widthImage, heightImage)
    }

    fun calculateSpanCount(): Int{

        var spanCount: Int = calculateWidthScreen()/ IMAGET_VIEW_APPROXIMATE_WIDTH
        if(spanCount < MIN_SPAN_COUNT) spanCount = MIN_SPAN_COUNT
        return spanCount
    }

    fun calculateWidthScreen():Int{
        if (widthScreen == 0) {
            val display = activity.windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            widthScreen = size.x
        }
        return widthScreen
    }

    companion object {
        private val IMAGET_VIEW_APPROXIMATE_WIDTH = 256
        private val MIN_SPAN_COUNT = 2
        private val HEIGHT_WIDTH_RELATION = 3/2

    }
}


