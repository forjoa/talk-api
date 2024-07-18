package com.talk_api.talk_api.controller;

import com.talk_api.talk_api.model.Conversation;
import com.talk_api.talk_api.model.Message;
import com.talk_api.talk_api.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversation")
public class ConversationController {
    @Autowired
    private ConversationService conversationService;

    @PostMapping("/conversation")
    public Conversation startConversation(@RequestBody Conversation conversation) {
        return conversationService.startConversation(conversation);
    }

    @PostMapping("/message")
    public Message sendMessage(@RequestBody Message message) {
        return conversationService.sendMessage(message);
    }

    @GetMapping("/messages/{conversationId}")
    public List<Message> getMessages(@PathVariable Long conversationId) {
        return conversationService.getMessages(conversationId);
    }
}
