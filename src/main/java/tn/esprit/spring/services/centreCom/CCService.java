package tn.esprit.spring.services.centreCom;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.entities.Client2;
import tn.esprit.spring.repositories.BoutiqueRepository;
import tn.esprit.spring.repositories.CCRepository;
import tn.esprit.spring.repositories.Client2Repository;
@Service
public class CCService implements ICCService {

	@Autowired
	CCRepository centreRepository;
	
	@Autowired
	BoutiqueRepository boutiqueRepository;
	
	@Autowired
	Client2Repository client2Repository;
	
	@Override
	public void ajouterCentre(CentreCommercial centre) {
		centreRepository.save(centre);
	}

	@Override
	public void ajouterEtaffecterListeboutique(List<Boutique> lb, Long idCentre) {
		CentreCommercial cc = new CentreCommercial();
		cc= centreRepository.findById(idCentre).orElse(null);
		for(Boutique b: lb) {
			b.setCentreCommercial(cc);	
		}
		boutiqueRepository.saveAll(lb);
	}

	@Override
	public void ajouterEtAffecterClientBoutiques(Client2 client, List<Long> idBoutiques) {

		for(Long idb:idBoutiques) {
			
		}
	}

	@Override
	public List<Boutique> listedeBoutiques(Long idCentre) {
		return boutiqueRepository.listedeBoutiques(idCentre);
	}

	@Override
	public List<Client2> listedeClients(Long idBoutique) {
		return boutiqueRepository.listedeClients(idBoutique);
	}

	@Override
	public Set<Client2> listeDeClientsParCategorie(Categorie categorie) {
		List<Client2> listAllClients = (List<Client2>) client2Repository.findAll();
		List<Boutique> listAllBoutiques = (List<Boutique>) boutiqueRepository.findAll();
		Set<Client2> list=null;
		for(Boutique b:listAllBoutiques)
			if(b.getCategorie()==categorie) {
				for(Client2 c:b.getClients2()) {
					list.add(c);
				}
			}
				
		return list;
	}

	
}
