package com.andrewm.weatherornot.data.model.forecast

import io.realm.RealmObject

open class MinutelyData : RealmObject() {
    open var time: Int? = 0
    open var precipIntensity: Double? = 0.0
    open var precipIntensityError: Double? = 0.0
    open var precipProbability: Double? = 0.0
    open var precipType: String? = null
}