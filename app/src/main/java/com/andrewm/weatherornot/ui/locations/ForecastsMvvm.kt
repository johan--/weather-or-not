package com.andrewm.weatherornot.ui.locations

interface ForecastsMvvm {

    interface ViewModel : IForecastsViewModel {
        fun onCardClick()
    }
}