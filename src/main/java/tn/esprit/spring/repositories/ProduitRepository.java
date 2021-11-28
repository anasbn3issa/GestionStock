package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {
	/*
		@Query("INSERT INTO fournisseur_produits(fournisseur_id_fournisseur,produits_id_produit	) VALUES (?1,?2)")
		public void assignFournisseurToProduit(Long fournisseurId,Long produitId);
		
		SELECT f FROM Facture f WHERE f.client.idClient = :idClient
	*/
	
	@Query("SELECT (p.prixUnitaire*count(p)) FROM Produit p, DetailFacture d WHERE (p.idProduit = :idProduit) AND (d.produit.idProduit = :idProduit) AND (d.facture.dateFacture BETWEEN :date1 AND :date2)")
	float getRevenuBrutProduit(@Param("idProduit")Long idProduit,@Param("date1")Date date1,@Param("date2") Date date2);
}
