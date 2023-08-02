package com.javachallenge.streamworker.components;

import com.javachallenge.streamworker.dataaccess.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
// Class
public class KafkaConsumer {

    final ChatService chatService;

    @Value("${product.topic}")
    private String topic;

    private MessagePublisher messagePublisher;
    @Autowired
    public KafkaConsumer(ChatService chatService, MessagePublisher messagePublisher) {
        this.chatService = chatService;
        this.messagePublisher = messagePublisher;
    }

    @KafkaListener(topics = "${product.topic}",
            groupId = "group_id")

    // Method
    public void consume(String message) {
        // Print statement
        try {
            chatService.save(topic,message);
            messagePublisher.publish(message);
            System.out.println("Published at topic: " + topic  + "\n    message: " + message);
        }catch (Exception ex)
        {
            System.out.println("Failed to publish with error: " + ex.getMessage());
        }
    }
}