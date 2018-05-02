package com.andrewm.weatherornot.ui.locations.recyclerview

import com.andrewm.weatherornot.ui.base.AdapterMvvmViewModel
import com.andrewm.weatherornot.ui.locations.ForecastsView

interface IForecastsViewModel: AdapterMvvmViewModel<ForecastsView> {
    fun reloadData(bypassLocalDatabase: Boolean = false)
    fun addForecastLocation(zipCode: String)
}