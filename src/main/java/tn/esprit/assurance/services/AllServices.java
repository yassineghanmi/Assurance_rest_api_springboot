package tn.esprit.assurance.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.assurance.entities.Assurance;
import tn.esprit.assurance.entities.Beneficiaire;
import tn.esprit.assurance.entities.Contrat;
import tn.esprit.assurance.entities.TypeContrat;
import tn.esprit.assurance.repositories.AssuranceRepo;
import tn.esprit.assurance.repositories.BeneficiaireRespo;
import tn.esprit.assurance.repositories.ContratRepo;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class AllServices implements IAllService{

    private final BeneficiaireRespo beneficiaireRespo;
    private final AssuranceRepo assuranceRepo;
    private final ContratRepo contratRepo;
    @Override
    public int ajouterBeneficaire(Beneficiaire bf) {
        Beneficiaire beneficiaire = beneficiaireRespo.save(bf);
        return beneficiaire.getCin();
    }

    @Override
    public int ajouterAssurance(Assurance a, int cinBf) {
        Beneficiaire beneficiaire = beneficiaireRespo.findByCin(cinBf);
        a.setBeneficiaire(beneficiaire);
        Contrat contrat = contratRepo.save(a.getContrat());
        a.setContrat(contrat);
        return assuranceRepo.save(a).getIdAssurance();
    }

    @Override
    public List<Contrat> getContratBf(int idBf) {
        return contratRepo.findByContratBf(idBf);
    }

    @Override
    public float getMontantBf(int cinBf) {
        List<Assurance> assuranceList = assuranceRepo.findByBeneficiaireIdBenef(cinBf);
        float montantSum = 0;
        for(Assurance assurance : assuranceList){
            float montant = assurance.getMontant();
            TypeContrat type = assurance.getContrat().getTypeContrat();
            switch (type){
                case Annuel -> {
                    montantSum = montant * 12 + montantSum;
                    break;
                }
                case Semestriel -> {
                    montantSum = montant * 6 + montantSum;
                    break;
                }
                case Mensuel -> {
                    montantSum = montant + montantSum;
                }
            }
        }
        return montantSum;
    }

    @Override
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat) {
        return beneficiaireRespo.findByAssuranceListContratTypeContrat(typeContrat);
    }

    @Override
    @Scheduled(fixedDelay = 60000)
    public void statistiques() {

        TreeMap<Integer, Integer> myStat = new TreeMap<>(Collections.reverseOrder());

        for (Beneficiaire b : beneficiaireRespo.findAll()) {
            myStat.put(b.getAssuranceList().size(), b.getCin());
        }
        for (Map.Entry<Integer, Integer> stat : myStat.entrySet()) {
            log.info(stat.getKey() + "|" + stat.getValue());
        }
    }


}
