package com.javachallenge.wsserver.services;

import com.javachallenge.wsserver.dataaccess.models.ChatModel;
import com.javachallenge.wsserver.dataaccess.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ChatService {
    final ChatRepository chatRepository;
    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<ChatModel> findByTopicOrderByMessageDateAsc(String topic) {
        return chatRepository.findByTopicOrderByMessageDateAsc(topic);
    }
}

