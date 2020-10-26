package com.example.openweather.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
class ForecastFragment : Fragment() {


    // Hilt needs to be setup
    @Inject
    lateinit var weatherForecastViewModelFactory: WeatherForecastViewModelFactory

    private lateinit var viewModel: WeatherForecastViewModel

    private val weatherListAdapter: WeatherListAdapter = WeatherListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forecast, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupUI()

        val cityName = arguments?.let { ForecastFragmentArgs.fromBundle(it).cityName }


        viewModel = weatherForecastViewModelFactory.create(WeatherForecastViewModel::class.java)


        cityName?.let { nonNullCityName ->
            viewModel.getWeatherForecast(nonNullCityName).observe(viewLifecycleOwner, Observer {
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
                    }
                })
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


    companion object {
        private val TAG = ForecastFragment::class.java.simpleName
    }


}