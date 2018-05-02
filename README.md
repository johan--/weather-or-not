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
### Phase Zero
This is where the project currently is. The goal of phase zero is to establish the codebase in a manner that will allow for:
* rapid development
* testability
* maintainability
* scalability

Phase Zero will not include much functionality, or pretty UIs. Functionality will be limited to a 
few screens that show minimal forecast information, and allow for adding additional locations.

During Phase Zero, the structure of the code, and patterns will seem like massive overkill for what the app does. 
Once again, keep in mind that the goal is to set ourselves up for a bigger, more complex future. 

At the end of Phase Zero, data flow through the app will look something like:

//TODO: Insert image of phase 1 data flow

### Phase One
The goal of Phase One will be to bring the UI up to speed. At the end of phase one, 
the app look and behave like a beautiful standard weather app. 

//TODO: Insert mockups

### Phase Two 
Phase two is when the unique features of this weather app will begin to be built. Phase two includes:
1) Setting up notification configurations/conditions
2) Receiving push notifications

The app will begin to get significantly more complicated at this point. In an effort to keep the client simple,
it will likely be a good idea to try and shift some/most of the dirty work to the server. Below is a dataflow diagram 
of how this might work:

//TODO: Insert phase 2 dataflow diagram

## Tech stack
This project will lean heavily on best practices established by: 
- https://github.com/androidstarters/android-starter
- https://github.com/patloew/countries


And will use commonly use libraries such as:
- [RxJava2](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [Retrofit](http://square.github.io/retrofit/) / [OkHttp](http://square.github.io/okhttp/)
- [Gson](https://github.com/google/gson)
- [Dagger 2](http://google.github.io/dagger/)
- [Espresso](https://google.github.io/android-testing-support-library/) for UI tests
- [Mockito](http://mockito.org/)


## Things to explore in more depth
Following the best practices laid out by the examples has meant (and will continue to mean) learning
many new frameworks. As work progresses, I will continue to explore things such as:

* More comprehensive understanding of how Dagger 2 works under the hood
* Realm ChangeListeners
* Using RxJava for more asynchronous work
* Comprehensive unit testing (of view models especially)
* Much more...

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