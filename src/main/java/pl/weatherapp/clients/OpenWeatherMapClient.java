package pl.weatherapp.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.weatherapp.models.Forecast;

@FeignClient(name = "openWeatherMapFeignClient", url = "${service.open-weather-map.url}")
public interface OpenWeatherMapClient {
    @GetMapping(value = "/data/2.5/weather")
    Forecast getCurrentWeatherByCity(@RequestParam("q") String cityName, @RequestParam("appid") String appKey);
}
