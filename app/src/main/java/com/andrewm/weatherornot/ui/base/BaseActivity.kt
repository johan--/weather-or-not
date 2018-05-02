package com.andrewm.weatherornot.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.andrewm.weatherornot.BR
import com.andrewm.weatherornot.WeatherOrNotApplication
import com.andrewm.weatherornot.injection.components.ActivityComponent
import com.andrewm.weatherornot.injection.components.DaggerActivityComponent
import com.andrewm.weatherornot.injection.modules.ActivityModule
import io.realm.Realm
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, VM : MvvmViewModel<*>> : AppCompatActivity(), MvvmView {

    // Inject a Realm INSTANCE into every Activity, since the INSTANCE
    // is cached and reused for a thread (avoids create/destroy overhead)
    @Inject
    protected lateinit var realm: Realm

    protected lateinit var binding: B

    @Inject
    protected lateinit var viewModel: VM

    internal val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .appComponent(WeatherOrNotApplication.appComponent)
                .build()
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveInstanceState(outState)
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            ActivityComponent::class.java.getDeclaredMethod("inject", this::class.java).invoke(activityComponent, this)
        } catch(e: NoSuchMethodException) {
            throw NoSuchMethodException("You forgot to add \"fun inject(activity: ${this::class.java.simpleName})\" in ActivityComponent")
        }
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        viewModel.detachView()
        realm.close()
    }

    /* Sets the content view, creates the binding and attaches the view to the view model */
    protected fun setAndBindContentView(savedInstanceState: Bundle?, @LayoutRes layoutResID: Int) {
        binding = DataBindingUtil.setContentView<B>(this, layoutResID)
        binding.setVariable(BR.vm, viewModel)
        viewModel.attachViewOrThrowRuntimeException(this, savedInstanceState)
    }

    fun <V : MvvmView> MvvmViewModel<V>.attachViewOrThrowRuntimeException(view: MvvmView, savedInstanceState: Bundle?) {
        try {
            @Suppress("UNCHECKED_CAST")
            this.attachView(view as V, savedInstanceState)
        } catch (e: ClassCastException) {
            if (this !is NoOpViewModel<*>) {
                throw RuntimeException(javaClass.simpleName + " must implement MvvmView subclass as declared in " + this.javaClass.simpleName)
            }
        }
    }
}