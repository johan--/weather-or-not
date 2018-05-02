package com.andrewm.weatherornot.injection.components

import android.content.Context
import android.content.res.Resources
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.data.remote.GoogleGeoCodeApi
import com.andrewm.weatherornot.injection.modules.AppModule
import com.andrewm.weatherornot.injection.modules.DataModule
import com.andrewm.weatherornot.injection.modules.NetModule
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.injection.scopes.PerApplication
import dagger.Component
import io.realm.Realm

@PerApplication
@Component(modules = [(AppModule::class), (NetModule::class), (DataModule::class)])
interface AppComponent : AppComponentProvides

interface AppComponentProvides {
    @AppContext
    fun appContext(): Context
    fun resources(): Resources

    fun realm(): Realm
    fun forecastRepo(): ForecastRepo
    fun darkSkyApi(): DarkSkyApi
    fun googleGeoCodeApi(): GoogleGeoCodeApi
}