package com.andrewm.weatherornot.ui

import android.view.View
import com.andrewm.weatherornot.databinding.RecyclerViewItemLocationBinding
import com.andrewm.weatherornot.ui.base.BaseViewHolder
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.locations.recyclerview.ForecastsMvvm

/**
 * A view holder to represent a single forecast
 */
class ForecastViewHolder(v: View) : BaseViewHolder<RecyclerViewItemLocationBinding, ForecastsMvvm.ViewModel>(v), MvvmView {

    init {
        bindContentView(v)
    }
}