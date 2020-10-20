package com.example.openweather.model.network

import com.google.gson.annotations.SerializedName

class Sys {
    @SerializedName("pod")
    val pod: String? = null

    override fun toString(): String {
        return "Sys{" +
                "pod = '" + pod + '\'' +
                "}"
    }
}