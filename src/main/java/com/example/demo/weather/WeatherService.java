package com.example.demo.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherData getTokyoWeather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Tokyo,jp&units=metric&appid=" + apiKey;

        WeatherApiResponse response = restTemplate.getForObject(url, WeatherApiResponse.class);
        if (response == null) {
            throw new RuntimeException("Failed to get weather data");
        }

        WeatherData data = new WeatherData();
        data.setTemperature(response.getMain().getTemp());
        data.setDescription(response.getWeather()[0].getDescription());

        return data;
    }

    // WeatherApiResponse, WeatherData のクラスは下記参照
}
