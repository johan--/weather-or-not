package com.andrewm.weatherornot.ui.util

import android.databinding.BindingAdapter
import android.view.View

object BindingAdapters {

    @BindingAdapter("android:onClick")
    @JvmStatic
    fun setOnClickListener(v: View, runnable: Runnable) {
        v.setOnClickListener { runnable.run() }
    }
}