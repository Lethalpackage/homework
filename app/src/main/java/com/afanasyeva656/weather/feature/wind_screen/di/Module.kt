package com.afanasyeva656.weather.feature.wind_screen.di

import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import com.afanasyeva656.weather.feature.wind_screen.ui.WindScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val windModule = module {
    viewModel {
        WindScreenViewModel(get<WeatherInteractor>())
    }
}