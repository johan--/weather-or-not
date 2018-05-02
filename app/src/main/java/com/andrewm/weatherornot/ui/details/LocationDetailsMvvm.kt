package com.andrewm.weatherornot.ui.details

import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.base.MvvmViewModel

interface LocationDetailsMvvm {

    interface View : MvvmView

    interface ViewModel: MvvmViewModel<View> {
        var forecast: Forecast?
        fun loadLatestForecast()
    }
}