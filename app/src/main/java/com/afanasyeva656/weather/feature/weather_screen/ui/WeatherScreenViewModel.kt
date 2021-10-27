package com.afanasyeva656.weather.feature.weather_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afanasyeva656.weather.feature.weather_screen.data.api.model.WeatherModel
import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WindDomainModel
import com.example.newsfeed.base.BaseViewModel
import com.example.newsfeed.base.Event
import kotlinx.coroutines.launch

class WeatherScreenViewModel(private val weatherInteractor: WeatherInteractor) :
    BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState(weatherModel = WeatherDomainModel(temperature = "", windDomainModel = WindDomainModel(0.0, 0) ), "")
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.GetWeather -> {
                weatherInteractor.getWeather().fold(
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessWeatherRequest(weatherModel =it))
                    },

                    onError =  {
                        processDataEvent(DataEvent.ErrorWeatherRequest(it.localizedMessage ?: ""))
                    }



                )
            }

            is DataEvent.SuccessWeatherRequest -> {
                return previousState.copy(
                    weatherModel = event.weatherModel
                )
            }
            is DataEvent.ErrorWeatherRequest -> {
                return previousState.copy(
                    errorMessage = event.errorMessage
                )
            }
        }
        return null
    }
}

