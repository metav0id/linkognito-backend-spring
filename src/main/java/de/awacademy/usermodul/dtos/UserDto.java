package de.awacademy.usermodul.dtos;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private String name;
    private Integer age;
    private String email;
    private String ort;
    private Boolean geschlecht;
    private String password;
    private String registeredDate;

    public UserDto() {
        this.registeredDate = LocalDate.now().toString();
    }
}
