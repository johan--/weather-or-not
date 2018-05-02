package com.andrewm.weatherornot.injection.modules

import com.andrewm.weatherornot.ui.details.LocationDetailsMvvm
import com.andrewm.weatherornot.ui.details.LocationDetailsViewModel
import com.andrewm.weatherornot.ui.locations.ForecastViewModel
import com.andrewm.weatherornot.ui.locations.recyclerview.ForecastsMvvm
import com.andrewm.weatherornot.ui.locations.recyclerview.ForecastsViewModel
import com.andrewm.weatherornot.ui.locations.recyclerview.IForecastsViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindLocationDetailsViewModel(locationDetailsViewModel: LocationDetailsViewModel): LocationDetailsMvvm.ViewModel

    @Binds
    internal abstract fun bindForecastsViewModel(forecastsViewModel: ForecastsViewModel): IForecastsViewModel

    @Binds
    internal abstract fun bindForecastViewModel(forecastViewModel: ForecastViewModel): ForecastsMvvm.ViewModel

}
