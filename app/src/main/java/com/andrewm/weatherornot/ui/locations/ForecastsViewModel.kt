package com.andrewm.weatherornot.ui.locations

import android.os.Bundle
import com.andrewm.weatherornot.data.local.ForecastRepo
import com.andrewm.weatherornot.data.remote.DarkSkyApi
import com.andrewm.weatherornot.injection.scopes.PerViewHolder
import com.patloew.countries.ui.base.viewmodel.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@PerViewHolder
class ForecastsViewModel
@Inject
constructor(
        override val adapter: ForecastsAdapter,
        private val darkSkyApi: DarkSkyApi,
        private val forecastRepo: ForecastRepo) : BaseViewModel<ForecastsView>(), ForecastsMvvm.ViewModel {

    override fun onCardClick() {
        //TODO ("not implemented")
    }

    private val compositeDisposable = CompositeDisposable()

    override fun attachView(view: ForecastsView, savedInstanceState: Bundle?) {
        super.attachView(view, savedInstanceState)
        //TODO
    }

    override fun detachView() {
        super.detachView()
        compositeDisposable.clear()
    }

    override fun reloadData() {

    }
}

