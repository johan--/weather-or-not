package com.andrewm.weatherornot.data.model.forecast

import io.realm.RealmObject

open class Alert : RealmObject() {
    open var title: String? = null
    open var time: Int? = 0
    open var expires: Int? = 0
    open var description: String? = null
    open var uri: String? = null
}