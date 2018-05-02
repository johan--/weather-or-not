package com.andrewm.weatherornot.ui.details

import com.andrewm.weatherornot.ui.IForecastViewModel
import com.andrewm.weatherornot.ui.base.MvvmView

interface LocationDetailsMvvm {

    interface View : MvvmView

    interface ViewModel: IForecastViewModel<View> {
        fun loadLatestForecast(zipCode: String, lat: String, lng: String)
    }
}