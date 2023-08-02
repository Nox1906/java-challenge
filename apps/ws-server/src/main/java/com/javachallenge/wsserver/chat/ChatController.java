package com.javachallenge.wsserver.chat;

import com.javachallenge.wsserver.dataaccess.dtos.ChatDTO;
import com.javachallenge.wsserver.dataaccess.models.ChatModel;
import com.javachallenge.wsserver.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ChatController {
    final ChatService chatService;
    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat.sendTopic")
    @SendTo("/topic/public")
    public Optional<ArrayList<ChatDTO>> sendMessage(
            @Payload ChatDTO chatMessage
    ) {
        List<ChatModel> list = chatService.findByTopicOrderByMessageDateAsc(chatMessage.getTopic());
        ArrayList<ChatDTO> resultList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (ChatModel model: list) {
                resultList.add(new ChatDTO(model.getTopic(), model.getMessage()));
            }
        }
        return Optional.of(resultList);
    }
}
