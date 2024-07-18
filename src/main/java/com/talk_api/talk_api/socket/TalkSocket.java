package com.talk_api.talk_api.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.talk_api.talk_api.model.Message;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TalkSocket {
    private final SocketIOServer server;

    @Autowired
    public TalkSocket(SocketIOServer server) {
        this.server = server;
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        System.out.println("client connected: " + client.getSessionId());
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        System.out.println("client disconnected: " + client.getSessionId());
    }

    @OnEvent("joinRoom")
    public void onJoinRoom(SocketIOClient client, String room) {
        client.joinRoom(room);
        System.out.println("client joined room: " + room);
    }

    @OnEvent("chat message")
    public void onChatMessage(SocketIOClient client, ChatMessage message) {
        server.getRoomOperations(message.getRoom()).sendEvent("chat message", message);
    }

    @Getter
    @Setter
    public static class ChatMessage {
        private String room;
        private String content;
        private Long senderId;
    }
}
