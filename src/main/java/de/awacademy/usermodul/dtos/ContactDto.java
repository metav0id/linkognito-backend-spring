package de.awacademy.usermodul.dtos;

import lombok.Data;

@Data
public class ContactDto {
    private Long id;
    private Long addressId;
    private String name;
    private String qrcode;
    private String nickname;
    private Boolean active;
}
