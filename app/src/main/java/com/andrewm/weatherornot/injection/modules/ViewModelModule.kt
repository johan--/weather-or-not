package com.andrewm.weatherornot.injection.modules

import com.andrewm.weatherornot.ui.details.LocationDetailsMvvm
import com.andrewm.weatherornot.ui.details.LocationDetailsViewModel
import com.andrewm.weatherornot.ui.locations.ForecastsMvvm
import com.andrewm.weatherornot.ui.locations.ForecastsViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    // Activities
    @Binds
    internal abstract fun bindLocationDetailsViewModel(locationDetailsViewModel: LocationDetailsViewModel): LocationDetailsMvvm.ViewModel

    // View Holders
    @Binds
    internal abstract fun bindForecastsViewModel(forecastsViewModel: ForecastsViewModel): ForecastsMvvm.ViewModel

}
