package de.awacademy.usermodul.dtos;

import lombok.Data;

@Data
public class SendMessageDto {
    private long id;
    private long addressId;
    private String text;

    public SendMessageDto(long id, long addressId, String text ){
        this.id = id;
        this.addressId = addressId;
        this.text = text;
    }
}
