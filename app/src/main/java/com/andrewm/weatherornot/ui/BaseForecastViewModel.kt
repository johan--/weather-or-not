package com.andrewm.weatherornot.ui

import android.annotation.SuppressLint
import android.content.Context
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.data.model.forecast.ForecastSettings
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.ui.base.MvvmView
import com.patloew.countries.ui.base.viewmodel.BaseViewModel
import java.lang.String.format

/**
 * Abstract implementation of BaseViewModel and IForecastViewModel.
 * BaseForecastViewModel should be responsible for any common things that all forecast-centric
 * viewModels need to do.
 */
abstract class BaseForecastViewModel<V : MvvmView>(@AppContext context: Context, protected val forecastRepo: ForecastRepo) : BaseViewModel<V>(), IForecastViewModel<V> {

    private var settings: ForecastSettings = forecastRepo.getForecastSettings(false)

    protected val ctx: Context = context.applicationContext

    override var forecast: Forecast = Forecast()
        protected set

    override val temperature: String?
        get() = getTemperatureForView()

    private fun convertToCelsius(temp: Double?): Double {
        return if (temp != null) ((temp - 32) * 5/9) else 0.0
    }

    @SuppressLint("DefaultLocale")
    private fun getTemperatureForView(): String {
        val temperature = forecast.currently?.temperature
        if (temperature != null) {
            val temp = if (settings.isUsingFahrenheit) temperature else convertToCelsius(temperature)
            val suffix = if (settings.isUsingFahrenheit) "°F" else "°C"
            return format("%.${2}f", temp) + suffix
        }
        return "Not Set"
    }

    override fun update(forecast: Forecast) {
        this.forecast = forecast
        notifyChange()
    }
}