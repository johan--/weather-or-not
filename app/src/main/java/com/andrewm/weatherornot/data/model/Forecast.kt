package com.andrewm.weatherornot.data.model

import io.realm.RealmList
import io.realm.RealmObject

open class Forecast : RealmObject(){
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













