package com.andrewm.weatherornot.data.model

import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import com.andrewm.weatherornot.BR
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Forecast : RealmObject(), android.databinding.Observable {

    @Transient
    private var mCallbacks: PropertyChangeRegistry? = null

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        synchronized(this) {
            if (mCallbacks == null) {
                mCallbacks = PropertyChangeRegistry()
            }
        }
        mCallbacks?.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        synchronized(this) {
            if (mCallbacks == null) {
                return
            }
        }
        mCallbacks?.remove(callback)
    }

    //TODO: come up with some other primary key
    @PrimaryKey
    open var key: String? = "key"

    private var lat: Double? = 0.0
    open var latitude: Double?
        @Bindable
        get() = lat
        set(value) {
            lat = value
            synchronized(this) {
                if (mCallbacks == null) {
                    return
                }
            }
            mCallbacks?.notifyCallbacks(this, BR.latitude, null)
        }

    open var longitude: Double? = 0.0
    open var timezone: String? = null
    open var currently: Currently? = null
    open var minutely: Minutely? = null
    open var hourly: Hourly? = null
    open var daily: Daily? = null
    open var alerts: RealmList<Alert>? = null
    open var flags: Flags? = null
}













