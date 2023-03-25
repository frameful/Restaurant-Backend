package com.mash.restaurant.configuration;

import com.mash.restaurant.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final FoodItemRepository foodItemRepository;
    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Autowired
    public WebSocketHandler(FoodItemRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        session.sendMessage(new TextMessage(foodItemRepository.findAll().toString()));
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session, @NonNull CloseStatus status) {
        sessions.remove(session);
    }

    public void sendToAllSessions(String message) {
        TextMessage textMessage = new TextMessage(message);
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(textMessage);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}