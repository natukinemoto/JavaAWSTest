package com.example.demo.weather;

import com.example.demo.chatgpt.OpenAIService;
import com.example.demo.weather.WeatherData;
import com.example.demo.weather.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherChatController {

    private final WeatherService weatherService;
    private final OpenAIService openAIService;

    public WeatherChatController(WeatherService weatherService, OpenAIService openAIService) {
        this.weatherService = weatherService;
        this.openAIService = openAIService;
    }

    @GetMapping("/weather-chat")
    public String weatherChat() {
        WeatherData weatherData = weatherService.getTokyoWeather();
        return openAIService.askWithWeather(weatherData);
    }
}
