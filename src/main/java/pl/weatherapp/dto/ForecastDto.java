package pl.weatherapp.dto;

import lombok.Value;
import pl.weatherapp.models.Forecast;

import java.math.BigDecimal;

@Value
public class ForecastDto {
    BigDecimal temperature;
    BigDecimal pressure;
    BigDecimal direction;
    BigDecimal windSpeed;
    BigDecimal cloudy;

    public ForecastDto(BigDecimal temperature, BigDecimal pressure, BigDecimal direction, BigDecimal windSpeed, BigDecimal cloudy) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.direction = direction;
        this.windSpeed = windSpeed;
        this.cloudy = cloudy;
    }

    public ForecastDto(Forecast forecast) {
        this.temperature = forecast.getMain().getTemp();
        this.pressure = forecast.getMain().getPressure();
        this.direction = forecast.getWind().getDeg();
        this.windSpeed = forecast.getWind().getSpeed();
        this.cloudy = forecast.getClouds().getAll();
    }
}
