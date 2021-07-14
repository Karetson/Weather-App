package pl.weather.adapter.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.weather.domain.Weather;

@FeignClient(name = "openWeatherMapClient", url = "${service.open-weather-map.url}")
public interface OpenWeatherMapClient {
    @GetMapping(value = "/data/2.5/weather")
    Weather getCurrentWeatherByCity(@RequestParam("q") String cityName, @RequestParam("appid") String appKey, @RequestParam String units);
}
