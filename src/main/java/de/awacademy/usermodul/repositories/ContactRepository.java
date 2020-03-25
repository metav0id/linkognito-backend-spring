package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.Contact;
import de.awacademy.usermodul.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    // @Query(value = "select * from Contact c where c.id =: id")



}
