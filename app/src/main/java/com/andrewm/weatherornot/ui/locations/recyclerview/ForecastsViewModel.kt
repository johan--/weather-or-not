package com.andrewm.weatherornot.ui.locations.recyclerview

import android.os.Bundle
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.model.Forecast
import com.andrewm.weatherornot.ui.locations.ForecastsView
import com.patloew.countries.ui.base.viewmodel.BaseViewModel
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ForecastsViewModel
@Inject
constructor(override val adapter: ForecastsAdapter, private val forecastRepo: ForecastRepo) : BaseViewModel<ForecastsView>(), IForecastsViewModel {

    private var disposable: Disposable? = null

    override fun attachView(view: ForecastsView, savedInstanceState: Bundle?) {
        super.attachView(view, savedInstanceState)
        disposable = forecastRepo.getAllForecasts().subscribe({ refreshView(it) }, { print(it) })
    }

    private fun refreshView(forecastList: List<Forecast>) {
        adapter.forecastList = forecastList
        adapter.notifyDataSetChanged()
        view?.onRefresh(true)
    }

    override fun reloadData() {
        disposable = forecastRepo.getAllForecasts().subscribe({ refreshView(it) }, { print(it) })
    }

    override fun detachView() {
        super.detachView()

        if (disposable != null) {
            disposable!!.dispose()
            disposable = null
        }
    }

}

