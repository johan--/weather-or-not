package com.andrewm.weatherornot.ui.base
import android.support.v7.widget.RecyclerView

interface AdapterMvvmViewModel<V : MvvmView> : MvvmViewModel<V> {
    val adapter: RecyclerView.Adapter<*>
}