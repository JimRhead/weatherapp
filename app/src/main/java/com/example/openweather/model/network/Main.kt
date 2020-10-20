package com.example.openweather.model.network

import com.google.gson.annotations.SerializedName

data class Main (
    @field:SerializedName("temp")
    val temp: Double? = 0.0,

    @field:SerializedName("temp_min")
    val tempMin: Double? =  0.0,

    @field:SerializedName("grnd_level")
    val grndLevel: Int? =  0,

    @field:SerializedName("temp_kf")
    val tempKf: Double? =  0.0,

    @field:SerializedName("humidity")
    val humidity: Int? = 0,

    @field:SerializedName("pressure")
    val pressure: Int? =0,

    @field:SerializedName("sea_level")
    val seaLevel: Int? = 0,

    @field:SerializedName("feels_like")
    val feelsLike: Double? = 0.0,

    @field:SerializedName("temp_max")
    val tempMax: Double? = 0.0
)