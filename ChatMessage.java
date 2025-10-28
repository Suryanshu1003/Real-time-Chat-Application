package com.example.chat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "messages")
public class ChatMessage {
    @Id
    private String id;
    private String sender;
    private String content;
    private String room;        // optional for multiple rooms
    private Instant timestamp;

    // constructors, getters, setters...
}
