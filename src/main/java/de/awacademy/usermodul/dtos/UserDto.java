package de.awacademy.usermodul.dtos;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private String name;
    private Integer age;
    private String email;
    private Boolean geschlecht;
    private String password;
    private LocalDateTime registierenDatum;
    private Long userID;

    public UserDto() {
        this.registierenDatum = LocalDateTime.now();
    }
}
