package com.andrewm.weatherornot.ui.details

import android.content.Context
import android.databinding.*
import android.os.Bundle
import com.andrewm.weatherornot.BR
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.ui.BaseForecastViewModel
import com.andrewm.weatherornot.ui.base.MvvmView
import com.patloew.countries.ui.base.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LocationDetailsViewModel
@Inject
constructor(@AppContext context: Context, forecastRepo: ForecastRepo, private val darkSkyApi: DarkSkyApi): BaseForecastViewModel<LocationDetailsMvvm.View>(context, forecastRepo), LocationDetailsMvvm.ViewModel {
    private var compositeDisposable = CompositeDisposable()

    override fun detachView() {
        super.detachView()
        compositeDisposable.clear()
    }

    override fun loadLatestForecast(zipCode: String, lat: String, lng: String) {
        compositeDisposable.add(darkSkyApi.getForecast(lat, lng)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.zip = zipCode
                    forecastRepo.save(it)
                    update(it)
                }, {}))
    }
}