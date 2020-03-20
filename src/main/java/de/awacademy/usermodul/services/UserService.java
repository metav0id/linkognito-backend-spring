package de.awacademy.usermodul.services;

import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.entities.User;
import de.awacademy.usermodul.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;

import java.time.LocalDateTime;


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

        userEntiy.setId(userDto.getId());
        userEntiy.setName(userDto.getName());
        userEntiy.setAge(userDto.getAge());
        userEntiy.setGeschlecht(userDto.getGeschlecht());
        userEntiy.setOrt(userDto.getOrt());
        userEntiy.setEmail(userDto.getEmail());
        userEntiy.setPassword(userDto.getPassword());
        userEntiy.setRegisteredDate(userDto.getRegisteredDate().toString());

        return userEntiy;

    }

    /**
     * Map the User Entiy to an DTO to respons request
     * @param user
     * @return userDto
     */
    public UserDto convertEtoD(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setGeschlecht(user.getGeschlecht());
        userDto.setOrt(user.getOrt());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRegisteredDate(LocalDateTime.parse(user.getRegisteredDate()));

        return userDto;

    }

    /**
     * Save new user to the database
     * @param userDto
     */

    public void addNewUser(UserDto userDto){
        userRepository.save(convertDtoE(userDto));
    }

    /**
     * Find an user from database with password and email
     * @param userDto
     * @return userDto
     */
    public UserDto findLoginUser(UserDto userDto) {
        User user = userRepository.findLoginUser(userDto.getEmail(), userDto.getPassword());
        return convertEtoD(user);
    }
}
