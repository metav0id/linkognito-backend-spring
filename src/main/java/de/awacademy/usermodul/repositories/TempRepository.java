package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.TempEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempRepository extends JpaRepository<TempEntity,Long> {
}
