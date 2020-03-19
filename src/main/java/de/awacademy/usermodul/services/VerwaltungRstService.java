package de.awacademy.usermodul.services;

import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.entities.User;
import de.awacademy.usermodul.repositories.VerwaltungRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VerwaltungRstService {

    private UserService userService;
    private final VerwaltungRestRepository vwRepository;

    @Autowired
    public VerwaltungRstService(VerwaltungRestRepository vwRepository) {
        this.vwRepository = vwRepository;
    }

    /**
     * Read Entity from database, which are created in an interval, then convert it into DTO
     * @param start
     * @param end
     * @return a List of DTO
     */
    public List<UserDto> readUsersInIntervall(LocalDateTime start, LocalDateTime end) {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = vwRepository.findByRegistierenDatumIntervall(start, end);

        for(User user : users){
            userDtos.add(userService.convertEtoD(user));
        }
        return userDtos;
    }
}
