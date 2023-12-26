package tn.esprit.assurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.assurance.entities.Beneficiaire;
import tn.esprit.assurance.entities.TypeContrat;

import java.util.Set;

public interface BeneficiaireRespo extends JpaRepository<Beneficiaire,Long> {
    Beneficiaire findByCin(int cin);
    Set<Beneficiaire> findByAssuranceListContratTypeContrat(TypeContrat typeContrat);
}
