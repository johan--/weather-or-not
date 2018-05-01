package com.andrewm.weatherornot.ui.locations

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andrewm.weatherornot.R
import com.andrewm.weatherornot.data.model.Forecast
import com.andrewm.weatherornot.injection.scopes.PerFragment
import com.andrewm.weatherornot.injection.scopes.PerViewHolder
import javax.inject.Inject

@PerViewHolder
class ForecastsAdapter
@Inject
constructor() : RecyclerView.Adapter<ForecastsViewHolder>() {

    var forecastList = emptyList<Forecast>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ForecastsViewHolder {
        return createViewHolder(viewGroup, R.layout.recycler_view_item_location, ::ForecastsViewHolder)
    }

    fun <T : RecyclerView.ViewHolder> createViewHolder(viewGroup: ViewGroup, @LayoutRes layoutResId: Int, newViewHolderAction: (View) -> T): T {
        val view = LayoutInflater.from(viewGroup.context).inflate(layoutResId, viewGroup, false)
        return newViewHolderAction(view)
    }

    override fun onBindViewHolder(forecastViewHolder: ForecastsViewHolder, position: Int) {
        //TODO: Figure this out
//        forecastViewHolder.viewModel.update(forecastList[position], position == forecastList.size - 1)
//        forecastViewHolder.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }
}
