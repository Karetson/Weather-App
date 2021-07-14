package pl.weather.util;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@Component
public class WeatherApiMock {
    private static final WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(9000));

    @Value("${service.open-weather-map.api-key}")
    String appkey;

    public void setUp() {
        wireMockServer.stop();
        wireMockServer.start();
        wireMockServer.resetAll();
    }

    public void end() {
        wireMockServer.stop();
    }

    public void mock(String cityName, int statusCode, String payload ) {
        String units = "metric";

        wireMockServer.stubFor(get(urlEqualTo("/data/2.5/weather?q=" + cityName + "&appid=" + appkey + "&units=" + units))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", "application/json")
                        .withBody(payload)));
    }
}