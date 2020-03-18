package de.awacademy.usermodul.services;

import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.entities.User;
import de.awacademy.usermodul.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private User convertDtoE(UserDto userDto){
        User userEntiy = new User();

        userEntiy.setName(userDto.getName());
        userEntiy.setAlter(userDto.getAge());
        userEntiy.setGeschlecht(userDto.getGeschlecht());
        userEntiy.setEmail(userDto.getEmail());
        userEntiy.setPassword(userDto.getPassword());

        return userEntiy;

    }

    /**
     * Save new user to the database
     * @param userDto
     */

    public void addNewUser(UserDto userDto){
        userRepository.save(convertDtoE(userDto));
    }
}
