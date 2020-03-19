package de.awacademy.usermodul.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessage {
    private long receiver;
    private long sender;
    private String timeStamp;
    private String senderName;
    private String text;
}
