package pl.weather.domain.dto;

import lombok.Value;
import pl.weather.domain.Weather;

import java.math.BigDecimal;

@Value
public class WeatherDto {
    BigDecimal temperature;
    BigDecimal pressure;
    BigDecimal direction;
    BigDecimal windSpeed;
    BigDecimal cloudy;

    public WeatherDto(Weather forecast) {
        this.temperature = forecast.getMain().getTemp();
        this.pressure = forecast.getMain().getPressure();
        this.direction = forecast.getWind().getDeg();
        this.windSpeed = forecast.getWind().getSpeed();
        this.cloudy = forecast.getClouds().getAll();
    }
}
