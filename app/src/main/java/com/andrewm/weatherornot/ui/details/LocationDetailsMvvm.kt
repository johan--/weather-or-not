package com.andrewm.weatherornot.ui.details

import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.ui.IForecastViewModel
import com.andrewm.weatherornot.ui.base.MvvmView

interface LocationDetailsMvvm {

    interface View : MvvmView

    interface ViewModel {
        val summary: String?
        val temperature: String?
        val humidity: String?

        fun loadLatestForecast(zipCode: String, lat: String, lng: String)
    }
}