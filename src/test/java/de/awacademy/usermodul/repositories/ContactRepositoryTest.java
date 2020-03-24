package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.Contact;
import de.awacademy.usermodul.entities.User;
import org.junit.Assert;
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

    @Test
    public void AddUser() {

        // prepare
        Contact contact = new Contact();
        contact.setNickname("Harry der Fensterputzer");
        contact.setQrcode("eroherherig");

        contact.setActive(true);
        contact.setConversation("blablabla");

        // run logic
        contactRepository.save(contact);

        // verify
        Long id = contact.getId();
        Contact contactFromDB = contactRepository.findById(id).get();

        Assert.assertEquals(contact.getNickname(), contactFromDB.getNickname());
    }

    @Test
    public void deleteUser() {

        // prepare
        Contact contact = new Contact();
        contact.setNickname("Harry der Fensterputzer");
        contact.setQrcode("eroherherig");
        contact.setId(23L);
        contact.setActive(true);
        contact.setConversation("blablabla");
        contactRepository.save(contact);

        // run logic
        Long id = contact.getId();
        this.contactRepository.deleteById(id);

        // verify
        Contact contactFromDB = contactRepository.findById(id).get();
        Assert.assertNull(contactFromDB);
    }
}
