package com.andrewm.weatherornot.data.model.forecast

import io.realm.RealmObject

open class Flags : RealmObject() {
    open var units: String? = null
}