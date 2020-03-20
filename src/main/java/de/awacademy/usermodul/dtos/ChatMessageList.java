package de.awacademy.usermodul.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatMessageList {
    private List<ChatMessage> chatMessages;

    public ChatMessageList(){
        this.chatMessages = new ArrayList<>();
    }
}
