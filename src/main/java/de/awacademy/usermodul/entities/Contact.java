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

    private String qrcode;
    private String nickname;
    private String conversation;
    private Boolean active;

}
