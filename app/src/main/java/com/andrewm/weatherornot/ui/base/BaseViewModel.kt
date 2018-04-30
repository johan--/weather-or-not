package com.patloew.countries.ui.base.viewmodel

import android.databinding.BaseObservable
import android.os.Bundle
import android.support.annotation.CallSuper
import com.andrewm.weatherornot.ui.base.MvvmView
import com.andrewm.weatherornot.ui.base.MvvmViewModel

abstract class BaseViewModel<V : MvvmView> : BaseObservable(), MvvmViewModel<V> {

    var view: V? = null
        private set

    @CallSuper
    override fun attachView(view: V, savedInstanceState: Bundle?) {
        this.view = view
        if (savedInstanceState != null) { restoreInstanceState(savedInstanceState) }
    }

    @CallSuper
    override fun detachView() {
        view = null
    }

    protected open fun restoreInstanceState(savedInstanceState: Bundle) { }

    override fun saveInstanceState(outState: Bundle) { }

}
