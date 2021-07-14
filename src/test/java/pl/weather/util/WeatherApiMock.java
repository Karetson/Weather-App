package pl.weather.util;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Component
public class WeatherApiMock {
    private final WireMockServer wireMockServer = new WireMockServer(9000);

    @Value("${service.open-weather-map.api-key}")
    String appkey;

    public void setUp() {
        wireMockServer.start();
    }

    public void end() {
        wireMockServer.stop();
    }

    public void mock(String cityName, int statusCode, String payload ) {
        String units = "metric";

        wireMockServer.stubFor(get(urlEqualTo("/data/2.5/weather?q=" + cityName + "&appkey=" + appkey + "&units=" + units))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", "application/json")
                        .withBody(payload)));
    }
}