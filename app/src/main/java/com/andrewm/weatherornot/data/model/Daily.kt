package com.andrewm.weatherornot.data.model

import io.realm.RealmList
import io.realm.RealmObject

open class Daily : RealmObject() {
    open var summary: String? = null
    open var icon: String? = null
    open var data: RealmList<DailyData>? = null
}