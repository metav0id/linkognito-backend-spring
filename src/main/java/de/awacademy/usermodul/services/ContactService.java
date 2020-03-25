package de.awacademy.usermodul.services;

import de.awacademy.usermodul.dtos.ContactDto;
import de.awacademy.usermodul.entities.Contact;
import de.awacademy.usermodul.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    /**
     * map contact DTO to entity
     * @param contactDto
     * @return Contact
     */

    private Contact convertDtoToEntity (ContactDto contactDto) {
        Contact contactEntity = new Contact();
        contactEntity.setId(contactDto.getId());
        contactEntity.setAddressId(contactDto.getAddressId());
        contactEntity.setName(contactDto.getName());
        contactEntity.setQrcode(contactDto.getQrcode());
        contactEntity.setActive(contactDto.getActive());
        contactEntity.setNickname(contactDto.getNickname());

        return contactEntity;
    }

    /**
     * map contact entity to DTO
     * @param contactEntity
     * @return Contact
     */

    private ContactDto convertEntityToDto (Contact contactEntity) {
        ContactDto contactDto = new ContactDto();
        contactDto.setId(contactEntity.getId());
        contactDto.setAddressId(contactEntity.getAddressId());
        contactDto.setName(contactEntity.getName());
        contactDto.setQrcode(contactEntity.getQrcode());
        contactDto.setActive(contactEntity.getActive());
        contactDto.setNickname(contactEntity.getNickname());
        return contactDto;
    }

    /**
     * add new contact to the database
     * @param contactDto
     */

    public void addNewContact(ContactDto contactDto){

        contactRepository.save(convertDtoToEntity(contactDto));
    }

    /**
     * remove contact from database
     * @param id
     */

    public void removeContact(Long id) {

        contactRepository.deleteById(id);
    }

    /**
     * update contact in database
     * @param contactDto
     */

    public void updateContact(ContactDto contactDto) {
        System.out.println(contactDto.getQrcode());
        contactRepository.save(convertDtoToEntity(contactDto));
    }

    /**
     * retrieve all contacts from database
     * @return List of contactDtos
     */

    public List<ContactDto> readAll() {
        List<Contact> all = contactRepository.findAll();
        List<ContactDto> dtos = new ArrayList<>();
        all.forEach(contact -> dtos.add(convertEntityToDto(contact)));
        return dtos;
    }

    /**
     * retrieve single contact from database by its id
     * @param id
     * @return ContactDto
     */

    public ContactDto readSingleContact(Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        Contact contact = contactOptional.get();
        return this.convertEntityToDto(contact);
    }
}
