package com.andrewm.weatherornot.data.model.forecast

import io.realm.RealmObject

open class DailyData : RealmObject() {
    open var time: Int? = 0
    open var summary: String? = null
    open var icon: String? = null
    open var sunriseTime: Int? = 0
    open var sunsetTime: Int? = 0
    open var moonPhase: Double? = 0.0
    open var precipIntensity: Double? = 0.0
    open var precipIntensityMax: Double? = 0.0
    open var precipIntensityMaxTime: Int? = 0
    open var precipProbability: Double? = 0.0
    open var precipType: String? = null
    open var temperatureHigh: Double? = 0.0
    open var temperatureHighTime: Int? = 0
    open var temperatureLow: Double? = 0.0
    open var temperatureLowTime: Int? = 0
    open var apparentTemperatureHigh: Double? = 0.0
    open var apparentTemperatureHighTime: Int? = 0
    open var apparentTemperatureLow: Double? = 0.0
    open var apparentTemperatureLowTime: Int? = 0
    open var dewPoint: Double? = 0.0
    open var humidity: Double? = 0.0
    open var pressure: Double? = 0.0
    open var windSpeed: Double? = 0.0
    open var windGust: Double? = 0.0
    open var windGustTime: Int? = 0
    open var windBearing: Int? = 0
    open var cloudCover: Double? = 0.0
    open var uvIndex: Int? = 0
    open var uvIndexTime: Int? = 0
    open var visibility: Double? = 0.0
    open var ozone: Double? = 0.0
    open var temperatureMin: Double? = 0.0
    open var temperatureMinTime: Int? = 0
    open var temperatureMax: Double? = 0.0
    open var temperatureMaxTime: Int? = 0
    open var apparentTemperatureMin: Double? = 0.0
    open var apparentTemperatureMinTime: Int? = 0
    open var apparentTemperatureMax: Double? = 0.0
    open var apparentTemperatureMaxTime: Int? = 0
}