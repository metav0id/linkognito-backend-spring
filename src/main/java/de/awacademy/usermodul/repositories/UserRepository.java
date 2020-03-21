package de.awacademy.usermodul.repositories;

import de.awacademy.usermodul.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select u from User u where u.email = :email AND u.password = :password ")
    User checkLoginUser(@Param("email") String email, @Param("password") String password);

    @Query(value = "select u from User u where u.email = :email")
    User checkRegisterEmail(@Param("email") String email);
}
