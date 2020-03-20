package de.awacademy.usermodul.dtos;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String ort;
    private String geschlecht;
    private String password;
    private LocalDateTime registeredDate;

    public UserDto() {
        this.registeredDate = LocalDateTime.now();
    }
}
