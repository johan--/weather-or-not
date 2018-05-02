package com.andrewm.weatherornot.ui.details

import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.ui.IForecastViewModel
import com.andrewm.weatherornot.ui.base.MvvmView

interface LocationDetailsMvvm {

    interface View : MvvmView

    interface ViewModel {
        fun reloadForecastFromRemote(zipCode: String, lat: String, lng: String)
        fun loadLocalForecast(zipCode: String)
    }
}