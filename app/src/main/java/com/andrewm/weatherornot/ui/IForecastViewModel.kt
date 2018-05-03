package com.andrewm.weatherornot.ui

import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.base.MvvmViewModel

/**
 * An interface to describe common things that all forecast-centric view models should conform to
 */
interface IForecastViewModel <V : MvvmView> : MvvmViewModel<V> {
    fun update(forecast: Forecast)
    val forecast: Forecast?
    val temperature: String?
}
