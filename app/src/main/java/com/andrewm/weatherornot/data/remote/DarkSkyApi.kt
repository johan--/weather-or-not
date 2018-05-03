package com.andrewm.weatherornot.data.remote
import com.andrewm.weatherornot.data.model.forecast.Forecast
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DarkSkyApi {

    @GET("/forecast/1eab77479dbefffeab6dd57a82251006/{lat},{lng}")
    fun getForecast(@Path("lat") lat: String, @Path("lng") lng: String) : Single<Forecast>
}