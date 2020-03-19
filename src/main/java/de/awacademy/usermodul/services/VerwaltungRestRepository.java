package de.awacademy.usermodul.services;

import de.awacademy.usermodul.repositories.TempRepository;
import de.awacademy.usermodul.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerwaltungRestRepository {

    private final UserRepository userRepository;

    @Autowired
    public VerwaltungRestRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
