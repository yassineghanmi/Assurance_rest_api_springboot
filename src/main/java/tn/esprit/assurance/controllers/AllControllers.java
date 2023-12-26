package tn.esprit.assurance.controllers;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.assurance.entities.Assurance;
import tn.esprit.assurance.entities.Beneficiaire;
import tn.esprit.assurance.entities.Contrat;
import tn.esprit.assurance.entities.TypeContrat;
import tn.esprit.assurance.services.AllServices;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class AllControllers {
    private final AllServices allServices;
    @PostMapping("addBenefciaire")
    public int ajouterBeneficaire(@RequestBody Beneficiaire bf) {
        return allServices.ajouterBeneficaire(bf);
    }
    @PostMapping("addAssurance/{cin-benef}")
    public int addAssurance(@RequestBody Assurance assurance, @PathVariable("cin-benef") int cinB){
        return allServices.ajouterAssurance(assurance, cinB);
    }
    @GetMapping("getbyIdBef/{idBf}")
    public List<Contrat> getContratBf(@PathVariable("idBf") int idBf) {
        return allServices.getContratBf(idBf);
    }
    @GetMapping("getMontant/{cinBf}")
    public float getMontantBf(@PathVariable("cinBf") int cinBf){
        return allServices.getMontantBf(cinBf);
    }
    @GetMapping("getBeneficairesAsType/{typeContrat}")
    public Set<Beneficiaire> getBeneficairesAsType(@PathVariable("typeContrat") TypeContrat typeContrat) {
        return allServices.getBeneficairesAsType(typeContrat);
    }
}
