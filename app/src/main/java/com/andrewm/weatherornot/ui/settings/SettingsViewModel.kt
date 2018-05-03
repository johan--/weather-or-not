package com.andrewm.weatherornot.ui.settings

import android.content.Context
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.data.model.forecast.ForecastSettings
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.patloew.countries.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject


class SettingsViewModel
@Inject
constructor(@AppContext context: Context, var forecastRepo: ForecastRepo): BaseViewModel<SettingsMvvm.View>(), SettingsMvvm.ViewModel {

    override var settings: ForecastSettings = forecastRepo.getForecastSettings()

    override fun updateTemperatureScaleSetting() {
        settings.isUsingFahrenheit = !settings.isUsingFahrenheit
        forecastRepo.save(settings)
    }
}