package com.andrewm.weatherornot.broadcastreceivers

import android.widget.Toast
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.util.Log
import com.andrewm.weatherornot.BuildConfig
import com.andrewm.weatherornot.WeatherOrNotApplication
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BootBroadcastReceiver : BroadcastReceiver() {

    private var compositeDisposable = CompositeDisposable()

    var forecastRepo: ForecastRepo? = null
    private var darkSkyApi: DarkSkyApi? = null

    override fun onReceive(context: Context, intent: Intent) {
        forecastRepo = WeatherOrNotApplication.appComponent.forecastRepo()

        //TODO: Figure out how to inject forecastRepo and darkSkyApi

        val httpClientBuilder = OkHttpClient().newBuilder()
        darkSkyApi =  Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_FORECAST_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .callFactory(httpClientBuilder.build())
                .build().create(DarkSkyApi::class.java)

        reloadAllForecastsFromRemote()
    }

    private fun reloadAllForecastsFromRemote() {
        if (forecastRepo != null) {
            var currentForecasts = forecastRepo!!.getAllForecastsOnce()
            for (forecast in currentForecasts) {
                loadFromDarkSky(forecast.zip.toString(), forecast.latitude.toString(), forecast.longitude.toString())
            }
        }
    }

    private fun loadFromDarkSky (zipCode: String, latitude: String, longitude: String) {
        if (darkSkyApi != null) {
            compositeDisposable.add(darkSkyApi!!.getForecast(latitude, longitude)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        it.zip = zipCode
                        forecastRepo?.save(it)
                    }, {}))
        }
    }
}