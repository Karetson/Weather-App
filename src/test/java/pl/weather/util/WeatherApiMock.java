package pl.weather.util;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Component
public class WeatherApiMock {

    private final WireMockServer wireMockServer = new WireMockServer(9000);

    public void setUp() {
        wireMockServer.start();
    }

    public void end() {
        wireMockServer.stop();
    }

    public void mock(String cityName, int statusCode, String payload ) {
        wireMockServer.stubFor(get(urlPathMatching("/data/2.5/weather?q=" + cityName))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", "application/json")
                        .withBody(payload)));
    }
}