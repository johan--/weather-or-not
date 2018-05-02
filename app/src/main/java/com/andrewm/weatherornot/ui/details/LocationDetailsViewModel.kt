package com.andrewm.weatherornot.ui.details

import android.content.Context
import android.databinding.*
import android.os.Bundle
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.Forecast
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.injection.qualifier.AppContext
import javax.inject.Inject

class LocationDetailsViewModel
@Inject
constructor(@AppContext context: Context, private val forecastRepo: ForecastRepo, private val darkSkyApi: DarkSkyApi): BaseObservable(), LocationDetailsMvvm.ViewModel {

    override fun attachView(view: LocationDetailsMvvm.View, savedInstanceState: Bundle?) {
    }

    override fun detachView() {
    }

    override fun saveInstanceState(outState: Bundle) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun loadLatestForecast() {

        darkSkyApi.getForecast("43.0389", "-87.9065").subscribe({
            forecastRepo.save(it)
            updateForecast()
        }, {print(it)})
    }

    @Bindable
    override var forecast: Forecast? = forecastRepo.getByField("key", "key", true)

    private fun updateForecast() {
        forecast = forecastRepo.getByField("key", "key", true)
        notifyChange()
    }
}