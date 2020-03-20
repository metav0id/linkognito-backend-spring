package de.awacademy.usermodul.services;


import de.awacademy.usermodul.entities.User;
import de.awacademy.usermodul.repositories.VerwaltungRestRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

//DER TEST MUSST NOCH GECHECKT WERDEN!!!
public class VerwaltungRestServiceTest {

    @Mock
    private VerwaltungRestRepository vwRestRepository;

    @InjectMocks
    private VerwaltungRestService vwService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void readUsersInIntervall(){
        //1. Prepare the data
        String from = "0000-00-00";
        String to = "0003-00-00";
        User userTest = new User();
        userTest.setRegisteredDate(from);
        List<User> users = new ArrayList<>();
        users.add(userTest);
        //2. Run my Logic
        Mockito.when(vwRestRepository.findByRegistierenDatumIntervall(from,to)).thenReturn(users);
        //3. Verify the result
        Mockito.verify(vwRestRepository,Mockito.times(1));
    }

}
