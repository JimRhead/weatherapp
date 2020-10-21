package com.example.openweather.model.repository

import com.example.openweather.model.local.LocalWeatherForecast

interface WeatherForecastRepository {

    suspend fun getWeatherForecast(cityName: String): LocalWeatherForecast
}