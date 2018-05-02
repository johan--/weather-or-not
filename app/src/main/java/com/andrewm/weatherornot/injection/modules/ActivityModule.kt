package com.andrewm.weatherornot.injection.modules

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.andrewm.weatherornot.injection.qualifier.ActivityContext
import com.andrewm.weatherornot.injection.qualifier.ActivityFragmentManager
import com.andrewm.weatherornot.injection.scopes.PerActivity
import com.andrewm.weatherornot.ui.base.navigation.ActivityNavigator
import com.andrewm.weatherornot.ui.base.navigation.Navigator

import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    @ActivityContext
    internal fun provideActivityContext(): Context = activity

    @Provides
    @PerActivity
    @ActivityFragmentManager
    internal fun provideFragmentManager(): FragmentManager = activity.supportFragmentManager

    @Provides
    @PerActivity
    internal fun provideNavigator(): Navigator = ActivityNavigator(activity)
}
