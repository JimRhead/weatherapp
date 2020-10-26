package com.example.openweather.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openweather.R
import com.example.openweather.ui.adapter.WeatherListAdapter
import com.example.openweather.viewmodel.Status
import com.example.openweather.viewmodel.WeatherForecastViewModel
import com.example.openweather.viewmodel.WeatherForecastViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_forecast.*
import javax.inject.Inject

@AndroidEntryPoint
class ForecastActivity: AppCompatActivity() {

    @Inject
    lateinit var weatherForecastViewModelFactory: WeatherForecastViewModelFactory

    private lateinit var viewModel : WeatherForecastViewModel

    private val weatherListAdapter: WeatherListAdapter = WeatherListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        setupUI()

        val cityName = intent.getStringExtra(EXTRA_MESSAGE)

        viewModel = weatherForecastViewModelFactory.create(WeatherForecastViewModel::class.java)

        cityName?.let { nonNullCityName ->
            viewModel.getWeatherForecast(nonNullCityName).observe(this, Observer  {
                    it?.let { result ->
                        when (result.status) {
                            Status.LOADING -> {
                                Log.d(TAG, "Loading...")
                            }
                            Status.SUCCESS -> {
                                Log.d(TAG, "Success..." + result.data)
                                result.data?.let { weatherData ->
                                    weatherListAdapter.setData(weatherData.list)
                                    forecastCityName.text = "${weatherData.city} ${weatherData.country}"
                                }
                            }
                            Status.ERROR -> {
                                Log.e(TAG, "Error..." + result.message)
                                // handle the error
                            }
                        }
                    } })

        }

    }

    private fun setupUI() {
        weatherForecastList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL))
            adapter = weatherListAdapter
        }
    }


    companion object{
        @JvmStatic
        fun newInstance(context: Context?, cityName: String): Intent {
            return Intent(context, ForecastActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, cityName)
            }
        }

        private const val EXTRA_MESSAGE = "CITY NAME"

        @JvmField
        val TAG = ForecastActivity::class.java.simpleName
    }


}