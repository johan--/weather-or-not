package com.andrewm.weatherornot.ui.details

import android.databinding.Observable
import android.os.Bundle
import com.andrewm.weatherornot.BuildConfig
import com.andrewm.weatherornot.R
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.databinding.ActivityLocationDetailsBinding
import com.andrewm.weatherornot.ui.base.BaseActivity
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.base.NoOpViewModel
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_location_details.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LocationDetailsActivity : BaseActivity<ActivityLocationDetailsBinding, LocationDetailsMvvm.ViewModel>(), MvvmView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(savedInstanceState, R.layout.activity_location_details)
        setSupportActionBar(binding.toolbar)


        viewModel.loadLatestForecast()
        viewModel.testNumber.set(53.09)


    }
}
