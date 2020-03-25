package de.awacademy.usermodul.controllers;

import de.awacademy.usermodul.dtos.ContactDto;
import de.awacademy.usermodul.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ContactsController {

    private final ContactService contactService;

    @Autowired
    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping ("/readAllContacts")
    @ResponseBody
    public List<ContactDto> readAllContacts(ContactDto contactDto){

        return contactService.readAll();
    }

    @GetMapping("/readContact")
    @ResponseBody
    public ContactDto readContact (Long id) {
        return contactService.readSingleContact(id);
    }

    @PutMapping("/updateContact")
        public Boolean updateContact (@RequestBody ContactDto contactDto) {
        contactService.updateContact(contactDto);
        return true;
    }

    @PostMapping("/addContact")
    public Boolean addContact(@RequestBody ContactDto contactDto) {
        contactService.addNewContact(contactDto);
        return true;
    }

    @DeleteMapping("/deleteContact")
    public Boolean deleteContact (@RequestBody Long id) {
        contactService.removeContact(id);
        return true;
    }


}
