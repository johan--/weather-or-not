package com.andrewm.weatherornot.data.model.forecast

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ForecastSettings : RealmObject() {

    @PrimaryKey
    open var key: String = "settings_key"
    open var isUsingFahrenheit: Boolean = true
}