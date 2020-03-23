package de.awacademy.usermodul.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChatMessageDto {
    private long id;
    private long addressId;
    private String time;
    private String name;
    private String text;
    @JsonProperty
    private boolean success;
}
