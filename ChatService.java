package com.example.chat.service;

import com.example.chat.model.ChatMessage;
import com.example.chat.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    private final ChatMessageRepository repo;

    public ChatService(ChatMessageRepository repo) { this.repo = repo; }

    public ChatMessage save(ChatMessage msg) { return repo.save(msg); }

    public List<ChatMessage> getHistory(String room) {
        return repo.findByRoomOrderByTimestampAsc(room);
    }
}
