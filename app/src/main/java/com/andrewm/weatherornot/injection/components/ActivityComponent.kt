package com.andrewm.weatherornot.injection.components

import android.content.Context
import android.support.v4.app.FragmentManager
import com.andrewm.weatherornot.injection.modules.ActivityModule
import com.andrewm.weatherornot.injection.modules.ViewModelModule
import com.andrewm.weatherornot.injection.qualifier.ActivityContext
import com.andrewm.weatherornot.injection.qualifier.ActivityFragmentManager
import com.andrewm.weatherornot.injection.scopes.PerActivity
import com.andrewm.weatherornot.ui.ForecastsActivity
import com.andrewm.weatherornot.ui.details.LocationDetailsActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(AppComponent::class)], modules = [(ActivityModule::class), (ViewModelModule::class)])
interface ActivityComponent : ActivityComponentProvides {
    fun inject(activity: ForecastsActivity)
    fun inject(activity: LocationDetailsActivity)
}

interface ActivityComponentProvides : AppComponentProvides {
    @ActivityContext
    fun activityContext(): Context
    @ActivityFragmentManager
    fun defaultFragmentManager(): FragmentManager
}