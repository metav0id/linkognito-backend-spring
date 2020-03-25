package de.awacademy.usermodul.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue
    private Long id;
    private Long addressId;
    private String name;
    private String qrcode;
    private String nickname;
    private Boolean active;

}
