package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void AddUser() {

        //1. Data Prepare
        User user = new User();
        user.setName("Test User");

        //2. Run my Logic
        userRepository.save(user);

        //3. Verify the result
        Long id = user.getId();
        User userFromDB = userRepository.findById(id).get();

        Assert.assertEquals(user.getName(), userFromDB.getName());
    }
}
