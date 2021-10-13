package com.afanasyeva656.weather.feature.weather_screen.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.coroutineScope
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherScreenActivity: AppCompatActivity() {
    val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        weatherScreenViewModel.lifeData.observe(this, Observer(::render))
        weatherScreenViewModel.requestWeather()
    }

    private fun render(state: WeatherDomainModel) {
        findViewById<TextView>(R.id.tvTempeture).let { it.text = state.temperature }
    }
}