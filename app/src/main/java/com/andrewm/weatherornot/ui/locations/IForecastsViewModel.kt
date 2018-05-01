package com.andrewm.weatherornot.ui.locations

import com.andrewm.weatherornot.ui.base.AdapterMvvmViewModel

interface IForecastsViewModel : AdapterMvvmViewModel<ForecastsView> {
    fun reloadData()
}
