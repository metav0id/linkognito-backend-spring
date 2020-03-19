package de.awacademy.usermodul.dtos;
import lombok.Data;

@Data
public class UserDto {
    private String name;
    private Integer age;
    private String email;
    private Boolean geschlecht;
    private String password;

    public UserDto() {
    }
}
