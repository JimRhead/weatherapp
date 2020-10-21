package com.example.openweather.model.network

import com.google.gson.annotations.SerializedName

data class Sys (
    @field:SerializedName("pod")
    val pod: String? = null
)
