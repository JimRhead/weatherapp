package com.example.openweather.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openweather.R
import com.example.openweather.model.local.LocalWeatherItem

class WeatherListAdapter : RecyclerView.Adapter<WeatherForecastViewHolder>() {

    private val listItems: MutableList<LocalWeatherItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.weather_list_item, parent, false)
        return WeatherForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (listItems.isEmpty()) 0 else listItems.size
    }

    override fun onBindViewHolder(viewHolder: WeatherForecastViewHolder, position: Int) {
        val listItem = listItems[position]
        viewHolder.bindData(listItem)
    }

    fun setData(items: List<LocalWeatherItem>?) {
        listItems.clear()
        items?.let {
            listItems.addAll(it)
        }
        notifyDataSetChanged()
    }
}
