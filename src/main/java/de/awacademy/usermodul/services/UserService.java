package de.awacademy.usermodul.services;

import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.entities.User;
import de.awacademy.usermodul.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Map the User DTO to an Entity to save it
     * @param userDto
     * @return User
     */
    public User convertDtoE(UserDto userDto){
        User userEntiy = new User();

        userEntiy.setName(userDto.getName());
        userEntiy.setAge(userDto.getAge());
        userEntiy.setGeschlecht(userDto.getGeschlecht());
        userEntiy.setEmail(userDto.getEmail());
        userEntiy.setPassword(userDto.getPassword());
        userEntiy.setRegistierenDatum(userDto.getRegistierenDatum());

        return userEntiy;

    }

    /**
     * Map the User Entiy to an DTO to respons request
     * @param user
     * @return userDto
     */
    public UserDto convertEtoD(User user){
        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setGeschlecht(user.getGeschlecht());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;

    }

    /**
     * Save new user to the database
     * @param userDto
     */

    public void addNewUser(UserDto userDto){
        userRepository.save(convertDtoE(userDto));
    }

}
