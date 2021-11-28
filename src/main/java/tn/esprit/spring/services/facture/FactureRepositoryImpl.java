package tn.esprit.spring.services.facture;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repositories.ClientRepository;
import tn.esprit.spring.repositories.FactureRepository;
import tn.esprit.spring.services.client.ClientServiceImpl;
import tn.esprit.spring.services.detailsfacture.DetailsFactureServiceImpl;
@Slf4j
@Service
public class FactureRepositoryImpl implements FactureRepositoryCustom{
	
	@Autowired
	private FactureRepository facturerepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private DetailsFactureServiceImpl detailFactureService;
	/*@Autowired
	private */
	@Override
	public List<Facture> retrieveAllFacture() {
		return (List<Facture>) facturerepository.findAll();
	}

	@Override
	public Facture addFacture(Facture f) {
		return facturerepository.save(f);
	}

	@Override
	public void deleteFacture(Long id) {
		facturerepository.deleteById(id);
	}

	@Override
	public Facture updateFacture(Facture f) {
		return facturerepository.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return facturerepository.findById(id).orElse(null);
	}

	@Override
	public void cancelFacture(Long id) {
			Facture facture = retrieveFacture(id);
			if(facture != null) {
				facture.setActive(false);
				updateFacture(facture);
			}
	}

	@Override
	public float calculChiffreAffaire(Date d1, Date d2) {
		//je vais pas travailler avec le service pour le moment, regardez la methode dans "package tn.esprit.spring.scheduled"
		return facturerepository.calculChiffreAffairesBetweenTwoDates(d1,d2);
	}

	@Override
	public List<Facture> getFactureByClient(Long idClient) {
		return facturerepository.getFactureByClient(idClient);
		
	}
	
	@Transactional
	@Override
	public Facture addFacture(Facture f, Long idClient) {
		float somme=0f;
		float remise=0f;
		for(DetailFacture parcours: f.getFactDetails())
			{
			float sommePrixUnitaire=0f;
			float remiseUnitaire=0f;
				sommePrixUnitaire+=parcours.getProduit().getPrixUnitaire()*parcours.getQte();
				remiseUnitaire+= sommePrixUnitaire * parcours.getPourcentageRemise()/100;
				parcours.setPrixTotal(somme);
				parcours.setMontantRemise(remiseUnitaire);
				detailFactureService.update(parcours);
				somme+=sommePrixUnitaire;
				remise+=remiseUnitaire;
			}
		f.setMontantFacture(somme);
		f.setMontantRemise(remise);
		f.setActive(true);
		f.setDateFacture(new Date());
		f.setClient(clientRepository.findById(idClient).orElse(null));
		return f;
	}

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		return facturerepository.calculChiffreAffairesParCategorie(categorieClient, startDate, endDate);
	}
}
