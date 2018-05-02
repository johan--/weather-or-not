package com.andrewm.weatherornot.injection.components

import com.andrewm.weatherornot.injection.modules.ViewHolderModule
import com.andrewm.weatherornot.injection.modules.ViewModelModule
import com.andrewm.weatherornot.injection.scopes.PerViewHolder
import com.andrewm.weatherornot.ui.ForecastViewHolder
import dagger.Component

@PerViewHolder
@Component(dependencies = [(ActivityComponent::class)], modules = [(ViewHolderModule::class), (ViewModelModule::class)])
interface ViewHolderComponent {
    fun inject(viewHolder: ForecastViewHolder)
}
