package com.example.demo.chatgpt;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatGptController {

    private final OpenAIService openAIService;

    public ChatGptController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping
    public String chat(@RequestParam String message) {
        return openAIService.ask(message);
    }

    @GetMapping("/today")
    public String today() {
        return openAIService.ask("現在の日付と東京の気温と天気と気を付けることを教えてください");
    }
}
