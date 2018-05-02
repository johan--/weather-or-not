package com.andrewm.weatherornot.data.model.forecast

import io.realm.RealmObject

open class Currently : RealmObject() {
    open var time: Int? = 0
    open var summary: String? = null
    open var icon: String? = null
    open var nearestStormDistance: Int? = 0
    open var precipIntensity: Double? = 0.0
    open var precipIntensityError: Double? = 0.0
    open var precipProbability: Double? = 0.0
    open var precipType: String? = null
    open var temperature: Double? = 0.0
    open var apparentTemperature: Double? = 0.0
    open var dewPoint: Double? = 0.0
    open var humidity: Double? = 0.0
    open var pressure: Double? = 0.0
    open var windSpeed: Double? = 0.0
    open var windGust: Double? = 0.0
    open var windBearing: Int? = 0
    open var cloudCover: Double? = 0.0
    open var uvIndex: Int? = 0
    open var visibility: Double? = 0.0
    open var ozone: Double? = 0.0
}