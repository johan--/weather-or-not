package com.andrewm.weatherornot.ui.base

import android.databinding.BaseObservable
import android.os.Bundle
import javax.inject.Inject

class NoOpViewModel<V : MvvmView>
@Inject
constructor() : BaseObservable(), MvvmViewModel<V> {

    override fun attachView(view: V, savedInstanceState: Bundle?) {}

    override fun saveInstanceState(outState: Bundle) {}

    override fun detachView() {}

}