package tn.esprit.assurance.services;

import tn.esprit.assurance.entities.Assurance;
import tn.esprit.assurance.entities.Beneficiaire;
import tn.esprit.assurance.entities.Contrat;
import tn.esprit.assurance.entities.TypeContrat;

import java.util.List;
import java.util.Set;

public interface IAllService {
    public int ajouterBeneficaire (Beneficiaire bf);
    public int ajouterAssurance (Assurance a, int cinBf);
    public List<Contrat> getContratBf (int idBf);
    public float getMontantBf (int cinBf);
    public Set<Beneficiaire> getBeneficairesAsType(TypeContrat typeContrat);
    public void statistiques();
}
