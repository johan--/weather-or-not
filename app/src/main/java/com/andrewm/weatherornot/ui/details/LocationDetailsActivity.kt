package com.andrewm.weatherornot.ui.details

import android.os.Bundle
import com.andrewm.weatherornot.R
import com.andrewm.weatherornot.databinding.ActivityLocationDetailsBinding
import com.andrewm.weatherornot.ui.base.BaseActivity
import com.andrewm.weatherornot.ui.base.MvvmView

class LocationDetailsActivity : BaseActivity<ActivityLocationDetailsBinding, LocationDetailsMvvm.ViewModel>(), MvvmView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(savedInstanceState, R.layout.activity_location_details)
        setSupportActionBar(binding.toolbar)

        viewModel.loadLatestForecast()
    }
}
