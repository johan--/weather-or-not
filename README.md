# WeatherOrNot

[![Build Status](https://travis-ci.org/moorea/weather-or-not.svg?branch=master)](https://travis-ci.org/moorea/weather-or-not)
[![codecov](https://codecov.io/gh/moorea/weather-or-not/branch/master/graph/badge.svg)](https://codecov.io/gh/moorea/weather-or-not)

## Introduction
WeatherOrNot is an Android application that will allow users to easily check the weather _and_ 
configure notifications around "whether or not" they will be able to do certain activities

For example: 
* Location - Milwaukee 
    * Activity - Sailing
    * Conditions when sailing is permitted
        * Wind speeds < 20 knots
        * Odds of sustained winds > 50%
        * Temperature > 65 degrees
        * Odds of rain < 20%
* Location - Milwaukee 
    * Activity - Riding Motorcycle
    * Conditions when riding is permitted
        * Temperature > 65 degrees
        * Temperature < 85 degrees
        * Odds of rain < 20%
        
## Phases

## Tech stack
// TODO


## Things to explore in more depth
* More comprehensive understanding of how Dagger 2 works under the hood
* Realm ChangeListeners
* Using RxJava for more asynchronous work
* Other things...


## Acknowledgments
//TODO

## License

Copyright 2018 Andrew Moore

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.