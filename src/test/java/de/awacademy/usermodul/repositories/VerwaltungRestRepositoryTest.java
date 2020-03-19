package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VerwaltungRestRepositoryTest {

    @Autowired
    private VerwaltungRestRepository vwRepository;

    @Test
    public void findByRegistierenDatumIntervallTest() {

        //1. Data Prepare
        String from = "0000-00-00";
        String to = "0001-00-00";

        User userTest0 = new User();
        userTest0.setRegisteredDate(from);
        vwRepository.save(userTest0);

        User userTest1 = new User();
        userTest1.setRegisteredDate(to);
        vwRepository.save(userTest1);


        //2. Run my Logic
        List<User> users = vwRepository.findByRegistierenDatumIntervall(from, to);

        //3. Verify the result

        Assert.assertEquals(2, users.size());

    }
}
