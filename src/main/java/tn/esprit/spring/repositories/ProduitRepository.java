package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import tn.esprit.spring.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {
	/*
		@Query("INSERT INTO fournisseur_produits(fournisseur_id_fournisseur,produits_id_produit	) VALUES (?1,?2)")
		public void assignFournisseurToProduit(Long fournisseurId,Long produitId);
		
	*/
}
