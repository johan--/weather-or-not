package com.andrewm.weatherornot.data.model

import io.realm.RealmObject

open class Flags : RealmObject() {
    open var units: String? = null
}