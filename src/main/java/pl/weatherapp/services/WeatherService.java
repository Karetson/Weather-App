package pl.weatherapp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.weatherapp.models.Forecast;
import pl.weatherapp.repositories.OpenWeatherMapClient;
import pl.weatherapp.repositories.WeatherRepository;

@Service
public class WeatherService implements WeatherRepository {
    private Logger logger = LoggerFactory.getLogger(WeatherService.class);

    private final String appKey;
    private final ObjectMapper objectMapper;
    private final OpenWeatherMapClient openWeatherMapFeignClient;

    public WeatherService(ObjectMapper objectMapper,
                          OpenWeatherMapClient openWeatherMapFeignClient,
                          @Value("${service.open-weather-map.api-key}") String appKey) {
        this.objectMapper = objectMapper;
        this.openWeatherMapFeignClient = openWeatherMapFeignClient;
        this.appKey = appKey;
    }

    @Override
    public Forecast getCurrentWeatherByCity(String cityName) {
        logger.debug("getCurrentWeatherByCity({})", cityName);
        Forecast forecast = openWeatherMapFeignClient.getCurrentWeatherByCity(cityName, appKey);


        return forecast;
    }
}
