package tn.esprit.assurance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Beneficiaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBenef;
    private int cin;
    private String nom;
    private String prenom;
    private String profession;
    private float salaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiaire" ,fetch=FetchType.EAGER)
    @ToString.Exclude
    private List<Assurance> assuranceList;
}
