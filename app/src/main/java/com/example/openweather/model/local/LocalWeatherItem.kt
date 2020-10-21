package com.example.openweather.model.local

data class LocalWeatherItem(
    val temp: Double? = 0.0,

    val tempMin: Double? = 0.0,

    val humidity: Int? = 0,

    val pressure: Int? = 0,

    val feelsLike: Double? = 0.0,

    val tempMax: Double? = 0.0,

    val windSpeed: Double? = 0.0,

    val summary: String? = null,

    val description: String? = null,

    val date: String? = null,

    val time: String? = null

)
