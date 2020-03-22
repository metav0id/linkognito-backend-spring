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

    //    User Registrierung REST
    @PostMapping("/registration")
    public Long Registration(@RequestBody UserDto userDto){
        boolean userExisted = (userService.checkRegisterEmail(userDto) != null);
        if(userExisted){
            System.out.println("into existed case: " + userService.checkRegisterEmail(userDto));
            return -1L;
        } else {
            System.out.println("into registable case: " + userDto);
            userService.addNewUser(userDto);
            return userService.checkRegisterEmail(userDto).getId();
        }
    }

    //    User Login REST
    @PostMapping("/login")
    public UserDto LoginUser(@RequestBody UserDto userDto){
        System.out.println("return " + userService.checkLoginUser(userDto) );
        return userService.checkLoginUser(userDto);
    }
}
