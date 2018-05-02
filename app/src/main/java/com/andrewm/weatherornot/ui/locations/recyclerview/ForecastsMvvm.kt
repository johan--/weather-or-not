package com.andrewm.weatherornot.ui.locations.recyclerview

import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.IForecastViewModel

interface ForecastsMvvm {

    interface ViewModel : IForecastViewModel<MvvmView> {
        fun onForecastSelected()
    }
}