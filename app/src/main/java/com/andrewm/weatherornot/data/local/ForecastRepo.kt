package com.andrewm.weatherornot.data.local

import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.data.model.forecast.ForecastSettings
import io.reactivex.Flowable
import io.reactivex.Single

interface ForecastRepo {
    fun getByField(field: String?, value: String?, detached: Boolean): Forecast?
    fun getForecastSettings(): ForecastSettings
    fun getAllForecasts(): Flowable<List<Forecast>>
    fun getAllForecastsOnce(): List<Forecast>
    fun save(forecast: Forecast)
    fun save(forecastSettings: ForecastSettings)
    fun delete(forecast: Forecast)
    fun detach(forecast: Forecast): Forecast
}