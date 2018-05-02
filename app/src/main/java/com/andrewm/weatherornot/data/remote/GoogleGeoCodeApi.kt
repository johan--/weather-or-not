package com.andrewm.weatherornot.data.remote

import com.andrewm.weatherornot.data.model.GeoCoding.GeoCodeResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GoogleGeoCodeApi {

    @GET("/maps/api/geocode/json?address={zip}")
    fun getForecast(@Path("zip") lat: String) : Single<GeoCodeResult>
}