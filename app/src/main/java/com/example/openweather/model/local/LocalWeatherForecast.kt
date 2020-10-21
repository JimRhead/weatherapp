package com.example.openweather.model.local

data class LocalWeatherForecast(
    val city: String?,

    val country: String?,

    val list: List<LocalWeatherItem>?
)
