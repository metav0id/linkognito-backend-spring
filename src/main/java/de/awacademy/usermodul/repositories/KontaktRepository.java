package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.Kontakt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontaktRepository extends JpaRepository<Kontakt,Long> {
}
