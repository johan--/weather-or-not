package com.andrewm.weatherornot

import android.app.Application
import android.content.res.Resources
import com.andrewm.weatherornot.injection.components.AppComponent
import com.andrewm.weatherornot.injection.components.DaggerAppComponent
import com.andrewm.weatherornot.injection.modules.AppModule
import io.reactivex.plugins.RxJavaPlugins
import io.realm.Realm
import io.realm.RealmConfiguration

class WeatherOrNotApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        Realm.setDefaultConfiguration(
                RealmConfiguration
                        .Builder()
                        .deleteRealmIfMigrationNeeded()
                        .build())

        Realm.getDefaultInstance()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
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
