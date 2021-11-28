package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.DetailFacture;

public interface FactureDetailRepository  extends CrudRepository<DetailFacture, Long>{

}
