package com.javachallenge.streamworker.dataaccess.repositories;

import com.javachallenge.streamworker.dataaccess.models.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<ChatModel, UUID> {

}
