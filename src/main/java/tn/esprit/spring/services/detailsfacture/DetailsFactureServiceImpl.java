package tn.esprit.spring.services.detailsfacture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.repositories.FactureDetailRepository;
@Service
public class DetailsFactureServiceImpl implements DetailFactureService {

	@Autowired
	private FactureDetailRepository factureDetailRepository;
	@Override
	public DetailFacture update(DetailFacture detail) {
		return factureDetailRepository.save(detail);
	}

}
