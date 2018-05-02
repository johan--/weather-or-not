package com.andrewm.weatherornot.data.model.forecast

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Forecast : RealmObject() {

    @PrimaryKey
    open var zip: String? = null
    open var latitude: Double? = 0.0
    open var longitude: Double? = 0.0
    open var timezone: String? = null
    open var currently: Currently? = null
    open var minutely: Minutely? = null
    open var hourly: Hourly? = null
    open var daily: Daily? = null
    open var alerts: RealmList<Alert>? = null
    open var flags: Flags? = null
}













