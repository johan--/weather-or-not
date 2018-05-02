package com.andrewm.weatherornot.ui.locations

import android.content.Context
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.ui.BaseForecastViewModel
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.locations.recyclerview.ForecastsMvvm
import javax.inject.Inject


class ForecastViewModel
@Inject
constructor(@AppContext context: Context, forecastRepo: ForecastRepo) : BaseForecastViewModel<MvvmView>(context, forecastRepo), ForecastsMvvm.ViewModel {
    override fun onForecastSelected() {
        print("Forecast selected")
//        navigator.startActivity(DetailActivity::class.java) { putExtra(Navigator.EXTRA_ARG, countryRepo.detach(country)) }
    }
}