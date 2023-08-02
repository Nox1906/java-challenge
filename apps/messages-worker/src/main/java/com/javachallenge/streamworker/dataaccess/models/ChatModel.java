package com.javachallenge.streamworker.dataaccess.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_CHAT")
public class ChatModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String topic;

    @Column(nullable = false, length = 250)
    private String message;
    @Column(nullable = false)
    private LocalDateTime messageDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getRegistrationDate() {
        return messageDate;
    }

    public void setRegistrationDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }
}