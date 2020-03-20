package de.awacademy.usermodul.dtos;

import lombok.Data;

@Data
public class ChatMessage {
    private long id;
    private long addressId;
    private String timeStamp;
    private String senderName;
    private String text;
}
