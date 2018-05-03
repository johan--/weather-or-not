package com.andrewm.weatherornot.injection.modules

import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.local.RealmForecastRepo
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindForecastRepo(realmCountryRepo: RealmForecastRepo): ForecastRepo

}
