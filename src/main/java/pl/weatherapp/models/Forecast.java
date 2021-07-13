package pl.weatherapp.models;

import java.util.Objects;

public class Forecast {
    private Double temperature;
    private Double pressure;
    private String direction;
    private Double windSpeed;
    private Double cloudy;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getCloudy() {
        return cloudy;
    }

    public void setCloudy(Double cloudy) {
        this.cloudy = cloudy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forecast forecast = (Forecast) o;
        return Objects.equals(temperature, forecast.temperature) &&
                Objects.equals(pressure, forecast.pressure) &&
                Objects.equals(direction, forecast.direction) &&
                Objects.equals(windSpeed, forecast.windSpeed) &&
                Objects.equals(cloudy, forecast.cloudy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, pressure, direction, windSpeed, cloudy);
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", direction='" + direction + '\'' +
                ", windSpeed=" + windSpeed +
                ", cloudy=" + cloudy +
                '}';
    }
}
