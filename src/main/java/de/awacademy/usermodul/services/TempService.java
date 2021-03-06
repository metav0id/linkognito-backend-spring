package de.awacademy.usermodul.services;

import de.awacademy.usermodul.repositories.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempService {

    private final TempRepository tempRepository;

    @Autowired
    public TempService(TempRepository tempRepository) {
        this.tempRepository = tempRepository;
    }
}
