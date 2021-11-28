package tn.esprit.spring.services.produit;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Produit;


public interface ProduitServiceImpl {
	
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
	
	Produit updateProduit(Produit p);
	
	public void assignFournisseurToProduit(Long fournisseurId,Long produitId);

	public void assignProduitToStock(Long idProduit, Long idStock);
	
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
