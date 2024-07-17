package com.talk_api.talk_api.repository;

import com.talk_api.talk_api.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
}
