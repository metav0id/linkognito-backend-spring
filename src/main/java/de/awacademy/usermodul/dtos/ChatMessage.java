package de.awacademy.usermodul.dtos;

import lombok.Data;

@Data
public class ChatMessage {
    private long id;
    private long addressId;
    private String time;
    private String name;
    private String text;
}
