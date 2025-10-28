package com.example.chat.controller;

import com.example.chat.model.ChatMessage;
import com.example.chat.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class ChatController {

    private final ChatService chatService;
    public ChatController(ChatService chatService) { this.chatService = chatService; }

    // STOMP endpoint receives messages at /app/chat.send
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        message.setTimestamp(Instant.now());
        chatService.save(message);           // persist
        return message;                      // broadcast to subscribers
    }

    // REST endpoint to fetch history for a room
    @GetMapping("/api/history/{room}")
    public List<ChatMessage> getHistory(@PathVariable String room) {
        return chatService.getHistory(room);
    }
}
