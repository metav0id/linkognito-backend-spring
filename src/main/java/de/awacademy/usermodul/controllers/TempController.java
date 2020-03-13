package de.awacademy.usermodul.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    @PostMapping("/...")
    public void postMethode(@RequestBody String beispiel){
        //todo...
    }
}
