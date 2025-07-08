package com.example.demo.chatgpt;

import com.example.demo.weather.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String ask(String question) {
        RestTemplate restTemplate = new RestTemplate();

        ChatRequest request = new ChatRequest();
        request.setModel("gpt-3.5-turbo");
        request.setMessages(Collections.singletonList(new ChatRequest.Message("user", question)));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<ChatRequest> httpEntity = new HttpEntity<>(request, headers);

        ResponseEntity<ChatResponse> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/chat/completions",
                httpEntity,
                ChatResponse.class
        );

        return response.getBody().getChoices().get(0).getMessage().getContent();
    }

    public String askWithWeather(WeatherData weatherData) {
        RestTemplate restTemplate = new RestTemplate();

        String prompt = String.format("東京の現在の気温は %.1f°C、天気は「%s」です。これに基づいて、今日の外出のアドバイスをください。",
                weatherData.getTemperature(),
                weatherData.getDescription());

        ChatRequest request = new ChatRequest();
        request.setModel("gpt-3.5-turbo");
        request.setMessages(Collections.singletonList(new ChatRequest.Message("user", prompt)));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<ChatRequest> httpEntity = new HttpEntity<>(request, headers);

        ResponseEntity<ChatResponse> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/chat/completions",
                httpEntity,
                ChatResponse.class
        );

        return response.getBody().getChoices().get(0).getMessage().getContent();
    }
}
