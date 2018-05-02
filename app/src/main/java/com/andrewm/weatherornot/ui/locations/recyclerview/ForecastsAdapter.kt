package com.andrewm.weatherornot.ui.locations.recyclerview

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andrewm.weatherornot.R
import com.andrewm.weatherornot.data.model.Forecast
import com.andrewm.weatherornot.injection.scopes.PerActivity
import com.andrewm.weatherornot.ui.ForecastViewHolder
import javax.inject.Inject

@PerActivity
class ForecastsAdapter
@Inject
constructor() : RecyclerView.Adapter<ForecastViewHolder>() {

    var forecastList = emptyList<Forecast>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ForecastViewHolder {
        return createViewHolder(viewGroup, R.layout.recycler_view_item_location, ::ForecastViewHolder)
    }

    private fun <T : RecyclerView.ViewHolder> createViewHolder(viewGroup: ViewGroup, @LayoutRes layoutResId: Int, newViewHolderAction: (View) -> T): T {
        val view = LayoutInflater.from(viewGroup.context).inflate(layoutResId, viewGroup, false)
        return newViewHolderAction(view)
    }

    override fun onBindViewHolder(forecastViewHolder: ForecastViewHolder, position: Int) {
        forecastViewHolder.viewModel.update(forecastList[position])
        forecastViewHolder.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }
}
