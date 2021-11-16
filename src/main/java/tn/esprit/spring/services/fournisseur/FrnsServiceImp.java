package tn.esprit.spring.services.fournisseur;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.repositories.FournisseurRepository;

public class FrnsServiceImp implements FournisseurServiceImpl {

	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Override
	public Fournisseur retrieveFournisseur(Long FournisseurId) {
		// TODO Auto-generated method stub
		return fournisseurRepository.getById(FournisseurId);
	}

}
