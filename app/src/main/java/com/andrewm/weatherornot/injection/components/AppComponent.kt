package com.andrewm.weatherornot.injection.components

import android.content.Context
import android.content.res.Resources
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.injection.modules.AppModule
import com.andrewm.weatherornot.injection.modules.DataModule
import com.andrewm.weatherornot.injection.modules.NetModule
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.injection.scopes.PerApplication
import dagger.Component
import io.realm.Realm


/* Copyright 2016 Patrick Löwenstein
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ------
 *
 * FILE MODIFIED 2017 Tailored Media GmbH */
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

//    fun toaster(): Toaster
}