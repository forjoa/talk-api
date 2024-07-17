package com.talk_api.talk_api.service;

import com.talk_api.talk_api.model.Conversation;
import com.talk_api.talk_api.model.Message;
import com.talk_api.talk_api.repository.ConversationRepository;
import com.talk_api.talk_api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Conversation startConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessages(Long conversationId) {
        return messageRepository.findByConversationId(conversationId);
    }
}
