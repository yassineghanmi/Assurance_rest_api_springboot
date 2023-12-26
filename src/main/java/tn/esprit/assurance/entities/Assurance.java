package tn.esprit.assurance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAssurance;
    private String designation;
    private float montant;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Beneficiaire beneficiaire;
    @ManyToOne
    @JsonIgnore
    private Contrat contrat;

}
