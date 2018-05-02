package com.andrewm.weatherornot.injection.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.andrewm.weatherornot.injection.qualifier.AppContext
import com.andrewm.weatherornot.injection.scopes.PerApplication
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class AppModule(private val app: Application) {

    @Provides
    @PerApplication
    @AppContext
    internal fun provideAppContext(): Context = app

    @Provides
    @PerApplication
    internal fun provideResources(): Resources = app.resources

    @Provides
    internal fun provideRealm(): Realm = Realm.getDefaultInstance()
}