package pl.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherApplicationIntegrationTest {
    @Autowired
    MockMvc mvc;

    @Test
    void shouldReturnOkStatus() throws Exception {
        String cityName = "Rzeszów";

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