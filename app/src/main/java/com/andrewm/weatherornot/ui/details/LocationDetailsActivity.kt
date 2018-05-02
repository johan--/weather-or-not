package com.andrewm.weatherornot.ui.details

import android.os.Bundle
import com.andrewm.weatherornot.R
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.databinding.ActivityLocationDetailsBinding
import com.andrewm.weatherornot.ui.base.BaseActivity
import com.andrewm.weatherornot.ui.base.MvvmView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LocationDetailsActivity : BaseActivity<ActivityLocationDetailsBinding, LocationDetailsMvvm.ViewModel>(), LocationDetailsMvvm.View {

    companion object {
        const val EXTRA_ZIP = "EXTRA_ZIP"
        const val EXTRA_LAT = "EXTRA_LAT"
        const val EXTRA_LNG = "EXTRA_LNG"
    }

    @Inject lateinit var darkSkyApi: DarkSkyApi
    @Inject lateinit var forecastRepo: ForecastRepo

    private var compositeDisposable = CompositeDisposable()

    fun loadLatestForecast(zipCode: String, lat: String, lng: String) {
        compositeDisposable.add(darkSkyApi.getForecast(lat, lng)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.zip = zipCode
                    forecastRepo.save(it)
                    viewModel.update(it)
                }, {}))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAndBindContentView(savedInstanceState, R.layout.activity_location_details)
        setSupportActionBar(binding.toolbar)

        loadLatestForecast(
                intent.getStringExtra(LocationDetailsActivity.EXTRA_ZIP),
                intent.getStringExtra(LocationDetailsActivity.EXTRA_LAT),
                intent.getStringExtra(LocationDetailsActivity.EXTRA_LNG))
    }

//    override fun onStart() {
//        super.onStart()
//        viewModel.loadLatestForecast(
//                intent.getStringExtra(LocationDetailsActivity.EXTRA_ZIP),
//                intent.getStringExtra(LocationDetailsActivity.EXTRA_LAT),
//                intent.getStringExtra(LocationDetailsActivity.EXTRA_LNG))
//    }
}
