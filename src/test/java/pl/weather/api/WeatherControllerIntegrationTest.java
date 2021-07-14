package pl.weather.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
class WeatherControllerIntegrationTest {
    @Mock
    WireMockServer wireMockServer = new WireMockServer(9000);

    @BeforeEach
    public void setUp() {
        wireMockServer.start();
    }

    @AfterEach
    public void end() {
        wireMockServer.stop();
    }

    @Test
    void shouldReturnCurrentWeatherByCity() {
        String cityName = "Rzeszów";

        stubFor(get(urlPathMatching("/data/2.5/weather?q=" + cityName))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "    \"temperature\": 32.8,\n" +
                                "    \"pressure\": 999,\n" +
                                "    \"direction\": 140,\n" +
                                "    \"windSpeed\": 4.63,\n" +
                                "    \"cloudy\": 0\n" +
                                "}")));
    }
}