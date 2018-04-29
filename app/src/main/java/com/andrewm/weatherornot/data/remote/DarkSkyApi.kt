package com.andrewm.weatherornot.data.remote
import com.andrewm.weatherornot.data.model.Forecast
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DarkSkyApi {

    @GET("/forecast/c60a4ae49ac3d4b6f2aafc8e7c852aaa/{lat},{lng}")
    fun getForecast(@Path("lat") lat: String, @Path("lng") lng: String) : Single<Forecast>
}