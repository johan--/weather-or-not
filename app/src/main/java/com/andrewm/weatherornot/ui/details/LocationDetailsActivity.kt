package com.andrewm.weatherornot.ui.details

import android.os.Bundle
import com.andrewm.weatherornot.R
import com.andrewm.weatherornot.databinding.ActivityLocationDetailsBinding
import com.andrewm.weatherornot.ui.base.BaseActivity

class LocationDetailsActivity : BaseActivity<ActivityLocationDetailsBinding, LocationDetailsViewModel>(), LocationDetailsMvvm.View {

    companion object {
        const val EXTRA_ZIP = "EXTRA_ZIP"
        const val EXTRA_LAT = "EXTRA_LAT"
        const val EXTRA_LNG = "EXTRA_LNG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAndBindContentView(savedInstanceState, R.layout.activity_location_details)
        setSupportActionBar(binding.toolbar)

        viewModel.loadLocalForecast(intent.getStringExtra(LocationDetailsActivity.EXTRA_ZIP))
    }

    override fun onStart() {
        super.onStart()
        viewModel.reloadForecastFromRemote(
                intent.getStringExtra(LocationDetailsActivity.EXTRA_ZIP),
                intent.getStringExtra(LocationDetailsActivity.EXTRA_LAT),
                intent.getStringExtra(LocationDetailsActivity.EXTRA_LNG))
    }
}
