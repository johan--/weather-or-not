package com.andrewm.weatherornot.ui.details

import android.databinding.ObservableDouble
import com.andrewm.weatherornot.data.model.Forecast
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.base.MvvmViewModel
import io.reactivex.Observable

interface LocationDetailsMvvm {

    interface View : MvvmView

    interface ViewModel: MvvmViewModel<View> {
        var forecast: Forecast?
        var testNumber: ObservableDouble
        fun loadLatestForecast()
    }
}