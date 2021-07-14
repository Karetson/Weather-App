package pl.weather;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.weather.util.WeatherApiMock;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherApplicationIntegrationTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    WeatherApiMock weatherApiMock;

    @BeforeEach
    public void setUp() {
        weatherApiMock.setUp();
    }

    @AfterEach
    public void end() {
        weatherApiMock.end();
    }

    @Test
    void shouldReturnOkStatus() throws Exception {
        String cityName = "Rzeszów";

        weatherApiMock.mock(cityName, 200, "{\n" +
                "    \"temperature\": 32.8,\n" +
                "    \"pressure\": 999,\n" +
                "    \"direction\": 140,\n" +
                "    \"windSpeed\": 4.63,\n" +
                "    \"cloudy\": 0\n" +
                "}");

        mvc.perform(get("/api/weather/data?cityName=" + cityName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnNotFoundStatus() throws Exception {
        mvc.perform(get("/api/weather/data?cityName=test"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnBadRequestStatus() throws Exception {
        mvc.perform(get("/api/weather/data?cityName="))
                .andExpect(status().isBadRequest());
    }
}