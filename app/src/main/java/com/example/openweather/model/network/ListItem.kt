package com.example.openweather.model.network

import com.google.gson.annotations.SerializedName

class ListItem {
    @SerializedName("dt")
    val dt = 0

    @SerializedName("pop")
    private val pop = 0.0

    @SerializedName("visibility")
    val visibility = 0

    @SerializedName("dt_txt")
    val dtTxt: String? = null

    @SerializedName("weather")
    val weather: List<WeatherItem>? = null

    @SerializedName("main")
    val main: Main? = null

    @SerializedName("clouds")
    private val clouds: Clouds? = null

    @SerializedName("sys")
    val sys: Sys? = null

    @SerializedName("wind")
    val wind: Wind? = null

    fun getPop(): Int {
        return pop.toInt()
    }

    fun getClouds(): Clouds? {
        return clouds
    }

    override fun toString(): String {
        return "ListItem{" +
                "dt = '" + dt + '\'' +
                ",pop = '" + pop + '\'' +
                ",visibility = '" + visibility + '\'' +
                ",dt_txt = '" + dtTxt + '\'' +
                ",weather = '" + weather + '\'' +
                ",main = '" + main + '\'' +
                ",clouds = '" + clouds + '\'' +
                ",sys = '" + sys + '\'' +
                ",wind = '" + wind + '\'' +
                "}"
    }
}