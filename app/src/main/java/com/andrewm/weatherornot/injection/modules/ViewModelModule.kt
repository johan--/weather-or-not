package com.andrewm.weatherornot.injection.modules

import com.andrewm.weatherornot.ui.details.LocationDetailsMvvm
import com.andrewm.weatherornot.ui.details.LocationDetailsViewModel
import dagger.Binds
import dagger.Module

/* Copyright 2016 Patrick Löwenstein
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */
@Module
abstract class ViewModelModule {

    // Activities

    @Binds
    internal abstract fun bindLocationDetailsViewModel(locationDetailsViewModel: LocationDetailsViewModel): LocationDetailsMvvm.ViewModel


//    // Fragments
//
//    internal abstract fun bindAllCountriesViewModel(allCountriesViewModel: AllCountriesViewModel): IAllCountriesViewModel
//
//    @Binds
//    internal abstract fun bindFavoriteCountriesViewModel(countryViewModel: FavoriteCountriesViewModel): IFavoriteCountriesViewModel
//
//
//    // View Holders
//
//    @Binds
//    internal abstract fun bindCountryViewModel(countryViewModel: CountryViewModel): CountryMvvm.ViewModel

}