package com.andrewm.weatherornot.ui.locations
import com.andrewm.weatherornot.ui.base.MvvmView

interface ForecastsView : MvvmView {
    fun onRefresh(success: Boolean)
}