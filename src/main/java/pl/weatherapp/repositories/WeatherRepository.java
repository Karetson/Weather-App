package pl.weatherapp.repositories;

import pl.weatherapp.models.Forecast;

public interface WeatherRepository {
    Forecast getCurrentWeatherByCity(String cityName);
}
