package pl.weather.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.weather.adapter.feign.client.OpenWeatherMapClient;

@Service
@RequiredArgsConstructor
public class WeatherFacade {
    @Value("${service.open-weather-map.api-key}")
    private final String appKey;
    @Value("${service.open-weather-map.units}")
    private final String units;
    private final OpenWeatherMapClient openWeatherMapFeignClient;

    public Weather getCurrentWeatherByCity(String cityName) {
        return openWeatherMapFeignClient.getCurrentWeatherByCity(cityName, appKey, units);
    }
}
