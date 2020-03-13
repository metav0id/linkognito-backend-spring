package de.awacademy.usermodul.services;


import de.awacademy.usermodul.repositories.TempRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TempServiceTest {

    @Mock
    private TempRepository tempRepository;

    @InjectMocks
    private TempService tempService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
}
