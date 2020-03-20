package de.awacademy.usermodul.controllers;

import de.awacademy.usermodul.dtos.ChatMessage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ChatControllerOldWay {
    final String URL_ALL_MESSAGES_FROM_SERVICE_MODUL = "";
    private List<ChatMessage> messagesList = new ArrayList<>();
    private List<ChatMessage> newMessagesList = new ArrayList<>();

    /**
     * Returns a list of all messages relate to connection from Service-API
     * @return
     */
    //ToDO Differentiate by clientID
    @GetMapping("/readAllMessages")
    public List<ChatMessage> readAllMessages(){

        //TODO implement method to get all messages from Service API
      /*  RestTemplate restTemplate = new RestTemplate();
        ChatMessageList response = restTemplate.getForObject(this.URL_ALL_MESSAGES_FROM_SERVICE_MODUL, ChatMessageList.class);
        List<ChatMessage> listAllChatMessages = response.getChatMessages();*/
        return this.messagesList;
    }


    /**
     * new Messages from Service-Modul will be sent to this API. Messages will be stored on list until they are called by API
     * @param chatMessage
     */
    @PostMapping("/sendNewMessage")
    private void newMessages(@RequestBody ChatMessage chatMessage){
        this.messagesList.add(chatMessage);
        System.out.println(this.messagesList.size());
        this.newMessagesList.add(chatMessage);
    }

    /**
     * Serves all new messages and cleans afterwards the new messages list
     * @return List of new Chat Messages
     */
    //ToDO Differentiate by clientID
    @PostMapping("/readNewMessages")
    private List<ChatMessage> readNewMessages(){
        List<ChatMessage> returnValue = List.copyOf(this.newMessagesList);
        this.newMessagesList.clear();
        return returnValue;
    }

    //TODO implement method to send a message to Service-API
}
