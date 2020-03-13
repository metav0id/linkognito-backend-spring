package de.awacademy.usermodul.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class TempEntity {

    @Id
    @GeneratedValue
    private Long id;
}
