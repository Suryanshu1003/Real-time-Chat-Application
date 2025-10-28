package com.example.chat.repository;

import com.example.chat.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByRoomOrderByTimestampAsc(String room);
}
