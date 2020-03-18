package de.awacademy.usermodul.controllers;

import de.awacademy.usermodul.dtos.ChatMessage;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {
    private List<ChatMessage> newMessageList = new ArrayList<>();

    @CrossOrigin
    @GetMapping("/readNewMessages")
    public List<ChatMessage> readAllMessages(){
        String timestamp = LocalDateTime.now().toString();

        ChatMessage message1 = new ChatMessage();
        message1.setReceiver(10);
        message1.setSender(5);
        message1.setTimeStamp(timestamp);
        message1.setSenderName("Nga");
        message1.setText("Hallo Welt");
        this.newMessageList.add(message1);

        return this.newMessageList;
    }


}
