package de.awacademy.usermodul.controllers;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class VerwaltungRestController {

    @GetMapping("/usersbetween{start}{end}")
    public void readUsersInIntervall(@RequestBody @PathVariable LocalDateTime start, @PathVariable LocalDateTime end){

    }
}
