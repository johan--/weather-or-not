package com.andrewm.weatherornot.ui.locations.recyclerview

import android.os.Bundle
import com.andrewm.weatherornot.WeatherOrNotApplication.Companion.realm
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.ui.locations.ForecastsView
import com.patloew.countries.ui.base.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject

class ForecastsViewModel
@Inject
constructor(override val adapter: ForecastsAdapter, private val darkSkyApi: DarkSkyApi, private val forecastRepo: ForecastRepo) : BaseViewModel<ForecastsView>(), IForecastsViewModel {

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
                compositeDisposable.add(darkSkyApi.getForecast(forecast.latitude.toString(), forecast.longitude.toString())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            it.zip = forecast.zip
                            forecastRepo.save(it)
                            loadFromDatabase()
                        }, {
                        }))
            }
        } else {
            loadFromDatabase()
        }
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

