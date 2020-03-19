package de.awacademy.usermodul.controllers;

import de.awacademy.usermodul.services.VerwaltungRstService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class VerwaltungRestController {

    private final VerwaltungRstService vwService;

    public VerwaltungRestController(VerwaltungRstService vwService) {
        this.vwService = vwService;
    }


    @GetMapping("/usersbetween{start}{end}")
    public void readUsersInIntervall(@RequestBody @PathVariable LocalDateTime start, @PathVariable LocalDateTime end){
        vwService.readUsersInIntervall(start, end);
    }
}
