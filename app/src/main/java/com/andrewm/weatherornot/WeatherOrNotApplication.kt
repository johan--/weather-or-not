package com.andrewm.weatherornot

import android.app.Application
import android.content.res.Resources
import com.andrewm.weatherornot.injection.components.AppComponent
import io.realm.Realm
import io.realm.RealmConfiguration

class WeatherOrNotApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().build())

        Realm.getDefaultInstance()
    }

    companion object {

        lateinit var instance: WeatherOrNotApplication
            private set

        lateinit var appComponent: AppComponent
            private set

        val realm: Realm
            get() = appComponent.realm()

        val res: Resources
            get() = instance.resources
    }
}
