package com.example.openweather.model.repository

import com.example.openweather.model.api.WeatherForecastAPI
import com.example.openweather.model.local.LocalWeatherForecast
import com.example.openweather.model.mapper.WeatherForecastResponseMapper

class OpenWeatherForecastRepository(private val weatherForecastAPI: WeatherForecastAPI,private val mapper: WeatherForecastResponseMapper): WeatherForecastRepository {

    override suspend fun getWeatherForecast(cityName: String): LocalWeatherForecast{
        val networkResponse = weatherForecastAPI.getWeatherForecast(cityName, "a199097733e5d36f4f198aa1a55ed4c5","Metric")
        return mapper.map(networkResponse)
    }
}