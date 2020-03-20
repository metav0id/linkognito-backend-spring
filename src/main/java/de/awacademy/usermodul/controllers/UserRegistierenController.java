package de.awacademy.usermodul.controllers;

import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.services.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRegistierenController {

    private final UserService userService;
    //Constructor injection
    public UserRegistierenController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/registration")
    public void postMethode(@RequestBody UserDto userDto){
        userService.addNewUser(userDto);
    }

    @GetMapping("/user")
    public UserDto findLoginUser(@RequestBody @RequestParam UserDto userDto){
        return userService.findLoginUser(userDto);
    }
}
