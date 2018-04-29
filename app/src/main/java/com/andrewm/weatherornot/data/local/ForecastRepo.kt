package com.andrewm.weatherornot.data.local

import com.andrewm.weatherornot.data.model.Forecast

interface ForecastRepo {
    fun getByField(field: String?, value: String?, detached: Boolean): Forecast?
    fun save(forecast: Forecast)
    fun delete(forecast: Forecast)
    fun detach(forecast: Forecast): Forecast
}