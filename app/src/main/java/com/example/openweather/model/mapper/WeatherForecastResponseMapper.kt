package com.example.openweather.model.mapper

import com.example.openweather.model.local.LocalWeatherForecast
import com.example.openweather.model.network.FiveDayForecast

interface WeatherForecastResponseMapper {

    fun map(networkResponse: FiveDayForecast): LocalWeatherForecast
}