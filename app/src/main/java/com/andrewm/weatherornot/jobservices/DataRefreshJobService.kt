package com.andrewm.weatherornot.jobservices

import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import com.andrewm.weatherornot.BuildConfig
import com.andrewm.weatherornot.WeatherOrNotApplication
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.local.RealmForecastRepo
import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.injection.components.DaggerActivityComponent
import com.andrewm.weatherornot.injection.modules.ActivityModule
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class DataRefreshJobService: JobService() {

     var forecastRepo: ForecastRepo? = null
     private var darkSkyApi: DarkSkyApi? = null

    private var compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        super.onCreate()

        forecastRepo = WeatherOrNotApplication.appComponent.forecastRepo()

        //TODO: Figure out how to inject forecastRepo and darkSkyApi

        val httpClientBuilder = OkHttpClient().newBuilder()
        darkSkyApi =  Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_FORECAST_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .callFactory(httpClientBuilder.build())
                .build().create(DarkSkyApi::class.java)

    }

    override fun onStartJob(params: JobParameters): Boolean {
        reloadAllForecastsFromRemote()
        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        return false
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

    companion object {
        private const val JOB_ID = 1
        private const val FIFTEEN_MINUTES = 15L * 60L * 1000L

        fun schedule(context: Context) {
            val component = ComponentName(context, DataRefreshJobService::class.java)
            val builder = JobInfo.Builder(JOB_ID, component)
                    .setRequiresCharging(false)
                    .setPeriodic(FIFTEEN_MINUTES)


            val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
            jobScheduler.schedule(builder.build())
        }
    }
}