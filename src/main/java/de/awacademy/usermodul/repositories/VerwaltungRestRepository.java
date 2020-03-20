package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerwaltungRestRepository extends JpaRepository<User,Long> {
    @Query(value = "select u from User u where u.registeredDate between :from AND :to ")
    List<User> findByRegistierenDatumIntervall(
            @Param("from") String from, @Param("to") String to);
}
