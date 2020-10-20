package com.example.openweather.model.network

import com.google.gson.annotations.SerializedName

data class FiveDayForecast (
    @field:SerializedName("city")
    val city: City?,

    @field:SerializedName("cnt")
    val cnt: Int?,

    @field:SerializedName("cod")
    val cod: String?,

    @field:SerializedName("message")
    val message: Int? = 0,

    @field:SerializedName("list")
    val list: List<ListItem>?
)
