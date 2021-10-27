package com.afanasyeva656.weather.feature.weather_screen.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenActivity

import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
  private val weatherScreenViewModel by viewModel<WeatherScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_weather)

        weatherScreenViewModel.viewState.observe(this, Observer(::render))
        weatherScreenViewModel.processUiEvent(UIEvent.GetWeather)


    }

    private fun render(state: ViewState) {
        findViewById<TextView>(R.id.tvTempeture).let { it.text = state.weatherModel.toString() }

        findViewById<Button>(R.id.buttonWind).setOnClickListener {
            Intent(this, WindScreenActivity::class.java).also { startActivity(it) }
        }
    }

}