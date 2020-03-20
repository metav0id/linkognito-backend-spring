package de.awacademy.usermodul.services;

import de.awacademy.usermodul.dtos.ContactDto;
import de.awacademy.usermodul.entities.Contact;
import de.awacademy.usermodul.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Contact convertDtoToEntity (ContactDto contactDto) {
        Contact contactEntity = new Contact();
        contactEntity.setActive(contactDto.getActive());
        contactEntity.setId(contactDto.getId());
        contactEntity.setNickname(contactDto.getNickname());
        contactEntity.setQrcode(contactDto.getQrCode());
        return contactEntity;
    }

    /**
     * map contact entity to DTO
     * @param contactEntity
     * @return Contact
     */

    public ContactDto convertEntityToDto (Contact contactEntity) {
        ContactDto contactDto = new ContactDto();
        contactDto.setActive(contactEntity.getActive());
        contactDto.setId(contactEntity.getId());
        contactDto.setNickname(contactEntity.getNickname());
        contactDto.setQrCode(contactEntity.getQrcode());
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
     * @param contactDto
     */

    public void removeContact(ContactDto contactDto) {
        contactRepository.delete(convertDtoToEntity(contactDto));
    }

    /**
     * update contact in database
     * @param contactDto
     */

    public void updateContact(ContactDto contactDto) {
        contactRepository.save(convertDtoToEntity(contactDto));
    }
}
