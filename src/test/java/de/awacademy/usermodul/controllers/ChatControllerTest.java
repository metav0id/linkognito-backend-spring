package de.awacademy.usermodul.controllers;


import org.junit.Test;

public class ChatControllerTest {
    final String URL_ALL_MESSAGES_FROM_SERVICE_MODUL = "";

    @Test
    public void readAllMessages(){
        /*RestTemplate restTemplate = new RestTemplate();
        *//*ChatMessageList response = restTemplate.getForObject(this.URL_ALL_MESSAGES_FROM_SERVICE_MODUL, ChatMessageList.class);*//*
        ChatMessage messageMetaData = new ChatMessage();

        //Id is my client id
        messageMetaData.setId(10);
        //addressId is chatroomId
        messageMetaData.setAddressId(5);
        ChatMessageList response = restTemplate.postForObject(this.URL_ALL_MESSAGES_FROM_SERVICE_MODUL, messageMetaData, ChatMessageList.class);
        List<ChatMessage> listAllChatMessages = response.getChatMessages();*/
    }
}
