package de.awacademy.usermodul.controllers;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import de.awacademy.usermodul.dtos.ChatMessageDto;
import de.awacademy.usermodul.dtos.ReadAllMessagesDto;
import de.awacademy.usermodul.dtos.ReadNewMessagesDto;
import de.awacademy.usermodul.exceptions.NoEntryForIDException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ChatControllerOldWay {
    private final String URL_SERVICE_SEND_MESSAGE = "https://31fcdb9c-6d24-4485-b1df-7ed6a9bd0fb5.mock.pstmn.io/user/sendmessage";
    final String URL_ALL_MESSAGES_FROM_SERVICE_MODUL = "https://31fcdb9c-6d24-4485-b1df-7ed6a9bd0fb5.mock.pstmn.io/user/getmessages";
    private List<ChatMessageDto> messagesList = new ArrayList<>();
    private List<ChatMessageDto> newMessagesList = new ArrayList<>();
    private RestTemplate restTemplate = new RestTemplate();
    HashMap<Long, List<ChatMessageDto>> tempNewChatMessages = new HashMap<>();

   //Google Guava Table for multi Key set map
    Table<Long, Long, List<ChatMessageDto>> newChatMessagesServiceModul = HashBasedTable.create();

    /**
     * Internal REST-API: Returns a list of all messages relate to connection from Service-API.
     * Requests Dto with id of user and addressId
     * @return
     */
    @PostMapping("/readAllMessages")
    public List<ChatMessageDto> readAllMessages(@RequestBody ReadAllMessagesDto readAllMessagesDto){

        System.out.println("Loading all messages from Service-Modul for UserID:" + readAllMessagesDto.getId() + " AddressID: " + readAllMessagesDto.getAddressId());

        ChatMessageDto[] response = restTemplate.postForObject(this.URL_ALL_MESSAGES_FROM_SERVICE_MODUL, readAllMessagesDto, ChatMessageDto[].class);
        List<ChatMessageDto> listChatMessages = Arrays.asList(response);
        System.out.println(listChatMessages.toString());

        return listChatMessages;
    }


    /**
     * External REST-API: new Messages from Service-Modul will be sent to this API. Messages will be stored on list until they are called by API. Needs id, addressId, name, text, timestamp
     * requires id, addressId, name, text and timestamp
     */
    @PostMapping("/service/pushmessages")
    private boolean newMessages(@RequestBody ChatMessageDto chatMessage){
        //TODO implement to separate by id, addressId and message
        //TEST 24.03.
        //scheme [row = id, column = addressId, List<ChatMessageDto>]
        Boolean isUserIdAndAddressIdAlreadyInTable = this.newChatMessagesServiceModul.containsRow(chatMessage.getId()) &&
                this.newChatMessagesServiceModul.containsColumn(chatMessage.getAddressId());

        if(isUserIdAndAddressIdAlreadyInTable){
            System.out.println("Add row: " + chatMessage.getId());
            this.newChatMessagesServiceModul.get(chatMessage.getId(), chatMessage.getAddressId()).add(chatMessage);
        }
        else {
            this.newChatMessagesServiceModul.put(chatMessage.getId(), chatMessage.getAddressId(), new ArrayList<>());
            this.newChatMessagesServiceModul.get(chatMessage.getId(), chatMessage.getAddressId()).add(chatMessage);
        }

        System.out.println("Entries for id: " + chatMessage.getId() + " addressId: " + chatMessage.getAddressId() + " : "
                + this.newChatMessagesServiceModul.get(chatMessage.getId(), chatMessage.getAddressId()).toString());

        return true;
    }

    /**
     * Internal REST-API: Serves all new messages and cleans afterwards the new messages list.
     * requires: id as long of user and addressId as long
     * @return List of new Chat Messages
     */
    @PostMapping("/readNewMessages")
    private List<ChatMessageDto> readNewMessages(@RequestBody ReadNewMessagesDto readNewMessagesDto){

        try {
            System.out.println("Loading new messages for userID: " + readNewMessagesDto.getId() + " addressId: " + readNewMessagesDto.getAddressId());

            if(this.newChatMessagesServiceModul.get(readNewMessagesDto.getId(), readNewMessagesDto.getAddressId()) == null){
                throw new NoEntryForIDException(readNewMessagesDto.getId(), readNewMessagesDto.getAddressId());
            }

            List<ChatMessageDto> returnValue = this.newChatMessagesServiceModul.get(readNewMessagesDto.getId(), readNewMessagesDto.getAddressId());
            this.newChatMessagesServiceModul.clear();
            return returnValue;
        } catch (NoEntryForIDException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Internal REST-API: Send a new message to Service-Modul API.
     * Requires: id, addressId, text in ChatMessageDto
     */
    @PostMapping("/sendMessage")
    private void sendNewMessage(@RequestBody ChatMessageDto newMessage){
        System.out.println("Message received from frontend...");
        System.out.println(newMessage.toString());

        ChatMessageDto response = this.restTemplate.postForObject(this.URL_SERVICE_SEND_MESSAGE,newMessage, ChatMessageDto.class);
        System.out.println("Status: "+response.isSuccess());
    }
}
