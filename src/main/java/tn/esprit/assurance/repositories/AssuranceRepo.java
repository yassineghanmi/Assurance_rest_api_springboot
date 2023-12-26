package tn.esprit.assurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.assurance.entities.Assurance;

import java.util.List;

public interface AssuranceRepo extends JpaRepository<Assurance,Long> {
    List<Assurance> findByBeneficiaireIdBenef(int idBenef);
}
