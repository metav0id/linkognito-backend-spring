package de.awacademy.usermodul.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;
    private Boolean geschlecht;
    private String ort;
    private String password;
    private String email;
    private String registeredDate;

    @OneToMany
    @JoinColumn()
    private List<Kontakt> kontakt;
}
