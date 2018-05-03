package com.andrewm.weatherornot.data.remote

import com.andrewm.weatherornot.data.model.geocoding.GeoCodeResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleGeoCodeApi {

    @GET("/maps/api/geocode/json")
    fun geocode(@Query("address") zip: String, @Query("key") key: String = "AIzaSyBRfZ9kud7XGfQZwIBOfo1STJyRl479Zf8") : Single<GeoCodeResult>
}