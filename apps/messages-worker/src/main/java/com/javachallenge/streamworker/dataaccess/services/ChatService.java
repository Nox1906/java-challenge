package com.javachallenge.streamworker.dataaccess.services;

import com.javachallenge.streamworker.dataaccess.models.ChatModel;
import com.javachallenge.streamworker.dataaccess.repositories.ChatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
public class ChatService {
    final ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Transactional
    public ChatModel save(String topic, String message) {
        var chatModel = new ChatModel();
        chatModel.setTopic(topic);
        chatModel.setMessage(message);
        chatModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return chatRepository.save(chatModel);
    }
}
