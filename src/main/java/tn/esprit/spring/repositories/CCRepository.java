package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;
@Repository
public interface CCRepository extends CrudRepository<CentreCommercial, Long> {
	/*@Query("")
	void ajouterEtaffecterListeboutique (List<Boutique> lb, Long idCentre);*/
}
