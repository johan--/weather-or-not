package com.andrewm.weatherornot.ui

import android.content.Context
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.forecast.Forecast
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.ui.base.MvvmView
import com.patloew.countries.ui.base.viewmodel.BaseViewModel

/**
 * Abstract implementation of BaseViewModel and IForecastViewModel.
 * BaseForecastViewModel should be responsible for any common things that all forecast-centric
 * viewModels need to do.
 */
abstract class BaseForecastViewModel<V : MvvmView>(@AppContext context: Context, protected val forecastRepo: ForecastRepo) : BaseViewModel<V>(), IForecastViewModel<V> {

    protected val ctx: Context = context.applicationContext

    override var forecast: Forecast = Forecast()
        protected set

    override fun update(forecast: Forecast) {
        this.forecast = forecast

        notifyChange()
    }
}