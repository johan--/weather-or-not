package com.andrewm.weatherornot.ui.base

import android.databinding.Observable
import android.os.Bundle

interface MvvmViewModel<V : MvvmView> : Observable {
    fun attachView(view: V, savedInstanceState: Bundle?)
    fun detachView()

    fun saveInstanceState(outState: Bundle)
}