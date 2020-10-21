package com.example.openweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkWeatherButton.setOnClickListener{getForecastforCity()}
    }

    private fun getForecastforCity(){
        val cityName = cityName.text.toString()
        startActivity(ForecastActivity.newInstance(this, cityName))
    }
}