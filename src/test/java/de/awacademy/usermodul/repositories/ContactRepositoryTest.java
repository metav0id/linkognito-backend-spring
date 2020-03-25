package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.Contact;
import de.awacademy.usermodul.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    Contact contact= new Contact();

    @Before
    public void prepare(){
        this.contact.setNickname("Harry der Fensterputzer");
        this.contact.setQrcode("eroherherig");
        this.contact.setActive(true);
        this.contact.setName("blablabla");
        this.contact.setAddressId(1243L);;
    }

    @Test
    public void addUser() {

        // run logic
        contactRepository.save(this.contact);

        // verify
        Long id = this.contact.getId();
        Contact contactFromDB = contactRepository.findById(id).get();

        Assert.assertEquals(this.contact.getNickname(), contactFromDB.getNickname());
    }

    @Test
    public void deleteUser() {

        // run logic
        Long id = this.contact.getId();
        this.contactRepository.deleteById(id);

        // verify
        Contact contactFromDB = contactRepository.findById(id).get();
        Assert.assertNull(contactFromDB);
    }
}
