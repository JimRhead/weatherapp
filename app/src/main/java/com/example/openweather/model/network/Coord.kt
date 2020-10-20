package com.example.openweather.model.network

import com.google.gson.annotations.SerializedName

data class Coord (
    @field: SerializedName("lon")
    val lon: Double? = 0.0,

    @field: SerializedName("lat")
    val lat: Double? = 0.0
)