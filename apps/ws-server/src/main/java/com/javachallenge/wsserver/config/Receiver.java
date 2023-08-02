package com.javachallenge.wsserver.config;

import com.javachallenge.wsserver.dataaccess.dtos.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.ArrayList;

public class Receiver implements MessageListener {
    @Autowired
    SimpMessagingTemplate messagingTemplate;
    @Override
    public void onMessage(Message message, byte[] pattern) {
        ArrayList<ChatDTO> messageList = new ArrayList<>();
        messageList.add(new ChatDTO("NewTopic", message.toString()));
        messagingTemplate.convertAndSend("/topic/public", messageList );
    }
}