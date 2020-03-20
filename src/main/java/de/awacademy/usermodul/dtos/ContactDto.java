package de.awacademy.usermodul.dtos;

import lombok.Data;

@Data
public class ContactDto {
    private Long id;
    private String nickname;
    private Boolean active;
    private String qrCode;
}
