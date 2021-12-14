package tn.esprit.spring.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.entities.Client2;

@Repository
public interface Client2Repository extends CrudRepository<Client2, Long> {
	/*@Query("select c client c where(c.")
	List<Client2> listeDeClientsParCategorie(Categorie categorie);*/
	
}
