package de.awacademy.usermodul.controllers;

import de.awacademy.usermodul.dtos.ContactDto;
import de.awacademy.usermodul.dtos.UserDto;
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

    @PostMapping ("/readAllContacts")
    public List<ContactDto> readAllContacts(@RequestBody UserDto userDto){
        System.out.println(userDto.getId());
        List <ContactDto> list = contactService.readAllFromExternalServices(userDto);
        System.out.println(list);
        return contactService.readAllFromExternalServices(userDto);

        // return contactService.readAll();
    }

    @GetMapping("/readContact")
    @ResponseBody
    public ContactDto readContact (Long id) {
        return contactService.readSingleContact(id);
    }

    @PutMapping("/updateContact")
        public void updateContact (@RequestBody ContactDto contactDto) {
        contactService.updateContact(contactDto);

    }

    @PostMapping("/addContact")
    public void addContact(@RequestBody ContactDto contactDto) {
        contactService.addNewContact(contactDto);

    }

    @PostMapping ("/deleteContact")
    public void deleteContact (@RequestBody ContactDto contactDto) {
        System.out.println(contactDto.getId());
        contactService.removeContact(contactDto.getId());
    }


}
