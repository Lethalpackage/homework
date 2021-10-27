package com.afanasyeva656.weather.feature.weather_screen.ui

import com.afanasyeva656.weather.feature.weather_screen.data.api.model.WeatherModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.example.newsfeed.base.Event

data class ViewState(
    val  weatherModel: WeatherDomainModel,
    val errorMessage: String?
    )

sealed class UIEvent(): Event{
object GetWeather : UIEvent()
}

sealed class DataEvent(): Event{

    data class SuccessWeatherRequest(val weatherModel: WeatherDomainModel) : DataEvent()
    data class ErrorWeatherRequest(val errorMessage: String) : DataEvent()
}