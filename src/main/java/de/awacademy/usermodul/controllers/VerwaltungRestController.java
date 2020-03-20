package de.awacademy.usermodul.controllers;

import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.services.VerwaltungRestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VerwaltungRestController {

    private final VerwaltungRestService vwService;

    public VerwaltungRestController(VerwaltungRestService vwService) {
        this.vwService = vwService;
    }


    @GetMapping("/users")
    public List<UserDto> readUsersInIntervall(@RequestParam String from, @RequestParam String to){
        return vwService.readUsersInIntervall(from, to);
    }
}
