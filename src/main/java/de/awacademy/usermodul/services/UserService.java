package de.awacademy.usermodul.services;

import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.entities.User;
import de.awacademy.usermodul.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.*;
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

        userEntiy.setName(userDto.getName());
        userEntiy.setAge(userDto.getAge());
        userEntiy.setGeschlecht(userDto.getGeschlecht());
        userEntiy.setOrt(userDto.getOrt());
        userEntiy.setEmail(userDto.getEmail());

        userEntiy.setPassword(BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt()));
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
     * Check if an user exists in database with the given password and email
     * @param userDto
     * @return userDto
     */
    public UserDto checkLoginUser(UserDto userDto) {
        User user = userRepository.checkRegisterEmail(userDto.getEmail());
        if(user != null && BCrypt.checkpw(userDto.getPassword(), user.getPassword())){
            return convertEtoD(user);
        }

       return null;
    }

    /**
     * Check if an user exists in database with the given email
     * @param userDto
     * @return userDto
     */
    public UserDto checkRegisterEmail(UserDto userDto) {
        User user = userRepository.checkRegisterEmail(userDto.getEmail());
        return user == null ? null : convertEtoD(user);
    }
}
