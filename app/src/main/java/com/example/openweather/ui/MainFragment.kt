package com.example.openweather.ui

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.openweather.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getForecast.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToForecastFragment(cityName.text.toString())
            findNavController().navigate(action)
        }}


}