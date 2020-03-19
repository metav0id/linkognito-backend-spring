package de.awacademy.usermodul.services;

import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.entities.User;
import de.awacademy.usermodul.repositories.VerwaltungRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VerwaltungRestService {

    private final UserService userService;
    private final VerwaltungRestRepository vwRepository;

    @Autowired
    public VerwaltungRestService(UserService userService, VerwaltungRestRepository vwRepository) {
        this.userService = userService;
        this.vwRepository = vwRepository;
    }

    /**
     * Read Entity from database, which are created in an interval, then convert it into DTO
     * @param from
     * @param to
     * @return a List of DTO
     */
    public List<UserDto> readUsersInIntervall(String from, String to) {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = vwRepository.findByRegistierenDatumIntervall(from, to);

        for(User user : users) {
            userDtos.add(userService.convertEtoD(user));
        }

        return userDtos;
    }
}
