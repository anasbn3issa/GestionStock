package tn.esprit.spring.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {
	
	void cancelFacture(Long id);

    @Query("SELECT  SUM (f.montantFacture) FROM Facture f WHERE f.dateFacture BETWEEN :datestart and :dateend")
    float calculChiffreAffaires(@Param("datestart") Date datestart, @Param("dateend") Date dateend);
}
