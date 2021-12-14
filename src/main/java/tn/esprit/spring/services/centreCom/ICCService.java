package tn.esprit.spring.services.centreCom;

import java.util.List;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.entities.Client2;

public interface ICCService {
	void ajouterCentre(CentreCommercial centre);
	void ajouterEtaffecterListeboutique (List<Boutique> lb, Long idCentre);
	void ajouterEtAffecterClientBoutiques(Client2 client, List<Long> idBoutiques);
	List<Boutique> listedeBoutiques(Long idCentre);
	List<Client2> listedeClients(Long idBoutique);
	List<Client2> listeDeClientsParCategorie(Categorie categorie);
}
