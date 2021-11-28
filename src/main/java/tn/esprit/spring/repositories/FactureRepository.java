package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {
	
	void cancelFacture(Long id);

    @Query("SELECT  SUM (f.montantFacture) FROM Facture f WHERE f.dateFacture BETWEEN :datestart and :dateend")
    float calculChiffreAffairesBetweenTwoDates(@Param("datestart") Date datestart, @Param("dateend") Date dateend);
    
    
    @Query("SELECT f FROM Facture f WHERE f.client.idClient = :idClient")
    List<Facture> getFactureByClient(@Param("idClient") Long idClient);
    
    @Query("SELECT SUM (f.montantFacture) FROM Facture f WHERE (f.dateFacture BETWEEN :startDate and :endDate) and (f.client.categorieClient LIKE :categorieClient)")
    float calculChiffreAffairesParCategorie(@Param("categorieClient") CategorieClient categorieClient, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
