package com.andrewm.weatherornot.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.andrewm.weatherornot.BuildConfig
import com.andrewm.weatherornot.R
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.databinding.ActivityMyLocationsBinding
import com.andrewm.weatherornot.ui.base.BaseActivity
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.base.NoOpViewModel
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import io.realm.Realm

import kotlinx.android.synthetic.main.activity_my_locations.*
import okhttp3.OkHttpClient
import javax.inject.Inject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MyLocationsActivity : BaseActivity<ActivityMyLocationsBinding, NoOpViewModel<MvvmView>>(), MvvmView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_locations)
        setSupportActionBar(toolbar)

        //TODO: Do this via DI
        val service = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_FORECAST_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .callFactory(OkHttpClient().newBuilder().build())
                .build().create(DarkSkyApi::class.java)


        //TODO: Do this elsewhere
        service.getForecast("43.0389", "-87.9065").subscribe({
            print(it)

        }, {print(it)})

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_my_locations, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
