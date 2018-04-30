package com.andrewm.weatherornot.ui.locations

import android.content.Context
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.injection.scopes.PerActivity
import io.realm.Realm
import javax.inject.Inject


@PerActivity
class MyLocationsViewModel
@Inject
constructor(@AppContext context: Context, forecastRepo: ForecastRepo, private val darkSkyApi: DarkSkyApi){

    private fun callForData() {
        darkSkyApi.getForecast("43.0389", "87.9065").subscribe({print(it)}, {print(it)})
    }


}