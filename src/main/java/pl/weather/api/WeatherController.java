package pl.weather.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.weather.domain.Weather;
import pl.weather.domain.dto.WeatherDto;
import pl.weather.domain.WeatherFacade;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherFacade weatherService;

    @GetMapping("/data")
    public WeatherDto getCurrentWeatherByCity(@RequestParam String cityName) {
        Weather forecast = weatherService.getCurrentWeatherByCity(cityName);
        return new WeatherDto(forecast);
    }
}
