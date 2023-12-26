package tn.esprit.assurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.assurance.entities.Contrat;

import java.util.List;

public interface ContratRepo extends JpaRepository<Contrat,Long> {
    @Query("select c from Contrat c " +
            "join Assurance a on c = a.contrat " +
            "where a.beneficiaire.idBenef = :idBef " +
            "order by c.dateEffet asc " +
            "limit 1")
    List<Contrat> findByContratBf(@Param("idBef") int idBef);

}
