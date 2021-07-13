package pl.weatherapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.weatherapp.models.Forecast;
import pl.weatherapp.repositories.WeatherRepository;

@RestController
public class WeatherController {
    private final WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/data")
    public Forecast getCurrentWeatherByCity(@RequestParam String cityName) {
        return weatherRepository.getCurrentWeatherByCity(cityName);
    }
}
