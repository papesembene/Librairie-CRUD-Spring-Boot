package sn.dakar.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Client extends BaseEntity {

    private String nom;
    private String telephone;
    private String email;
    private String adresse;
}