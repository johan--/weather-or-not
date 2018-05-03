package com.andrewm.weatherornot.ui.settings

import com.andrewm.weatherornot.data.model.forecast.ForecastSettings
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.base.MvvmViewModel
import com.patloew.countries.ui.base.viewmodel.BaseViewModel

interface SettingsMvvm {

    interface View : MvvmView

    interface ViewModel: MvvmViewModel<View> {
        var settings: ForecastSettings
        fun updateTemperatureScaleSetting()
    }
}