package de.awacademy.usermodul.services;


import de.awacademy.usermodul.dtos.UserDto;
import de.awacademy.usermodul.entities.User;
import de.awacademy.usermodul.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewUser(UserDto userDto){
        //1. Prepare the data
        int beforeNewcome = userRepository.findAll().size();
        User user = userService.convertDtoE(userDto);
        //2. Run my Logic
        Mockito.doNothing().when(userRepository).save(user);
        //3. Verify the result
        Assert.assertEquals(userRepository.findAll().size(), beforeNewcome + 1);

    }

}
