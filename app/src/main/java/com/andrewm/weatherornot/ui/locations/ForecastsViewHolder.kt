package com.andrewm.weatherornot.ui.locations

import android.view.View
import com.andrewm.weatherornot.databinding.RecyclerViewItemLocationBinding
import com.andrewm.weatherornot.ui.base.BaseViewHolder
import com.andrewm.weatherornot.ui.base.MvvmView

class ForecastsViewHolder(v: View) : BaseViewHolder<RecyclerViewItemLocationBinding, ForecastsMvvm.ViewModel>(v), MvvmView {

    init {
        bindContentView(v)
    }
}