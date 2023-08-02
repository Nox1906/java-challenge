package com.javachallenge.wsserver.dataaccess.repositories;

import com.javachallenge.wsserver.dataaccess.models.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<ChatModel, UUID> {
    List<ChatModel> findByTopicOrderByMessageDateAsc(String topic);
}
