package com.andrewm.weatherornot.ui.locations.recyclerview

import android.os.Bundle
import com.andrewm.weatherornot.WeatherOrNotApplication.Companion.realm
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.data.remote.GoogleGeoCodeApi
import com.andrewm.weatherornot.ui.locations.ForecastsView
import com.patloew.countries.ui.base.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject

class ForecastsViewModel
@Inject
constructor(
        override val adapter: ForecastsAdapter,
        private val darkSkyApi: DarkSkyApi,
        private val googleGeoCodeApi: GoogleGeoCodeApi,
        private val forecastRepo: ForecastRepo) : BaseViewModel<ForecastsView>(), IForecastsViewModel {

    private var compositeDisposable = CompositeDisposable()

    override fun attachView(view: ForecastsView, savedInstanceState: Bundle?) {
        super.attachView(view, savedInstanceState)
        compositeDisposable.add(forecastRepo.getAllForecasts().subscribe({ refreshView(it) }, { print(it) }))
    }

    private fun refreshView(forecastList: List<Forecast>) {
        adapter.forecastList = realm.copyFromRealm(forecastList)
        adapter.notifyDataSetChanged()
        view?.onRefresh(true)
    }

    override fun reloadData(bypassLocalDatabase: Boolean) {
        if (bypassLocalDatabase) {
            for (forecast in adapter.forecastList) {
                loadFromDarkSky(forecast.zip.toString(), forecast.latitude.toString(), forecast.longitude.toString())
            }
        } else {
            loadFromDatabase()
        }
    }

    private fun loadFromDarkSky (zipCode: String, latitude: String, longitude: String) {
        compositeDisposable.add(darkSkyApi.getForecast(latitude, longitude)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.zip = zipCode
                    forecastRepo.save(it)
                    loadFromDatabase()
                }, {}))
    }

    override fun addForecastLocation(zipCode: String) {
        compositeDisposable.add(
                googleGeoCodeApi.geocode(zipCode).subscribe({
                    val lat = it.results.first().geometry.location.lat
                    val lng = it.results.first().geometry.location.lng
                    loadFromDarkSky(zipCode, lat.toString(), lng.toString())
                },{})
        )
    }

    private fun loadFromDatabase() {
        compositeDisposable.add(forecastRepo.getAllForecasts().subscribe({
            refreshView(it)
        }, { print(it) }))
    }

    override fun detachView() {
        super.detachView()

        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}

