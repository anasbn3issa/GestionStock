package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Client2;

@Repository
public interface BoutiqueRepository extends CrudRepository<Boutique, Long> {

	@Query("SELECT b FROM boutique b WHERE (b.centreCommercial.id = ?1)")
	List<Boutique> listedeBoutiques(Long idCentre);
	@Query("SELECT c FROM client2 c WHERE (c.centreCommercial.id = ?1)")
	List<Client2> listedeClients(Long idBoutique);
}
