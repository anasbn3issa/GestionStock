package tn.esprit.spring.services.facture;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Facture;

public interface FactureRepositoryCustom {

	List<Facture> retrieveAllFacture();

	Facture addFacture(Facture f);

	void deleteFacture(Long id);

	Facture updateFacture(Facture f);

	Facture retrieveFacture(Long id);

	void cancelFacture(Long id);

	float calculChiffreAffaire(Date d1, Date d2);

	List<Facture> getFactureByClient(Long idClient);

	Facture addFacture(Facture f, Long idClient);

	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
}
