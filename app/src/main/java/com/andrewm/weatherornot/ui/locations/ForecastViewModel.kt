package com.andrewm.weatherornot.ui.locations

import android.content.Context
import android.content.Intent
import android.net.NetworkInfo
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.ui.BaseForecastViewModel
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.base.Navigator
import com.andrewm.weatherornot.ui.details.LocationDetailsActivity
import com.andrewm.weatherornot.ui.locations.recyclerview.ForecastsMvvm
import javax.inject.Inject

class ForecastViewModel
@Inject
constructor(@AppContext context: Context, forecastRepo: ForecastRepo, protected val navigator: Navigator) : BaseForecastViewModel<MvvmView>(context, forecastRepo), ForecastsMvvm.ViewModel {
    override fun onForecastSelected() {
        navigator.startActivity(LocationDetailsActivity::class.java) {
            putExtra(LocationDetailsActivity.EXTRA_ZIP, forecast.zip)
            putExtra(LocationDetailsActivity.EXTRA_LAT, forecast.latitude.toString())
            putExtra(LocationDetailsActivity.EXTRA_LNG, forecast.longitude.toString())
        }
    }
}