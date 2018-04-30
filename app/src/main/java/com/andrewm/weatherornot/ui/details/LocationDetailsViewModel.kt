package com.andrewm.weatherornot.ui.details

import android.content.Context
import android.databinding.Observable
import android.databinding.ObservableDouble
import android.databinding.ObservableField
import android.os.Bundle
import com.andrewm.weatherornot.BuildConfig
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.Forecast
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.injection.scopes.PerActivity
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@PerActivity
class LocationDetailsViewModel
@Inject
constructor(@AppContext context: Context, private val forecastRepo: ForecastRepo, private val darkSkyApi: DarkSkyApi): LocationDetailsMvvm.ViewModel {
    override var testNumber: ObservableDouble = ObservableDouble(5.9)

    override fun loadLatestForecast() {

        darkSkyApi.getForecast("43.0389", "-87.9065").subscribe({
            forecastRepo.save(it)
        }, {print(it)})
        val forecastX = forecastRepo.getByField("key", "key", true)
        forecast = forecastX
        this.forecast?.latitude = 94.2
    }

    override var forecast: Forecast? = forecastRepo.getByField("key", "key", true)

    override fun attachView(view: LocationDetailsMvvm.View, savedInstanceState: Bundle?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun detachView() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveInstanceState(outState: Bundle) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
       //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}