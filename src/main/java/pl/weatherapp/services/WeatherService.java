package pl.weatherapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.weatherapp.clients.OpenWeatherMapClient;
import pl.weatherapp.models.Forecast;
import pl.weatherapp.repositories.WeatherRepository;

@Service
@RequiredArgsConstructor
public class WeatherService implements WeatherRepository {
    private static final String APP_KEY = "e340e3bfc6132fc8a03ed1ce48e2e3dc";
    private final OpenWeatherMapClient openWeatherMapFeignClient;

//    public WeatherService(@Value("${service.open-weather-map.api-key}") String appKey,
//                          OpenWeatherMapClient openWeatherMapFeignClient) {
//        this.appKey = appKey;
//        this.openWeatherMapFeignClient = openWeatherMapFeignClient;
//    }

    @Override
    public Forecast getCurrentWeatherByCity(String cityName) {
        return openWeatherMapFeignClient.getCurrentWeatherByCity(cityName, APP_KEY);
    }
}
