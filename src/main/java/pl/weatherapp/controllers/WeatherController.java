package pl.weatherapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.weatherapp.dto.ForecastDto;
import pl.weatherapp.models.Forecast;
import pl.weatherapp.services.WeatherService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private WeatherService weatherService;

    @GetMapping("/data")
    public ForecastDto getCurrentWeatherByCity(@RequestParam String cityName) {
        Forecast forecast = weatherService.getCurrentWeatherByCity(cityName);
        return new ForecastDto(forecast);
    }
}
