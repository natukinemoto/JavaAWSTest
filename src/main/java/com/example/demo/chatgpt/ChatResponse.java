package com.example.demo.chatgpt;

import java.util.List;

public class ChatResponse {
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public static class Choice {
        private ChatRequest.Message message;

        public ChatRequest.Message getMessage() {
            return message;
        }

        public void setMessage(ChatRequest.Message message) {
            this.message = message;
        }
    }
}
