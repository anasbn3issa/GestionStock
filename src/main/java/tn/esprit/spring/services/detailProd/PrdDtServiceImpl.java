package tn.esprit.spring.services.detailProd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.repositories.ClientRepository;
import tn.esprit.spring.repositories.ProdDetailRepository;

@Service
public class PrdDtServiceImpl implements ProdDetServiceImpl{
	
	@Autowired
	private ProdDetailRepository prodDetailRepository;

	@Override
	public List<DetailProduit> retrieveAllPrdoDetails() {
		// TODO Auto-generated method stub
		return (List<DetailProduit>) prodDetailRepository.findAll();
	}

	@Override
	public DetailProduit addProdDetail(DetailProduit c) {
		// TODO Auto-generated method stub
		return prodDetailRepository.save(c);
	}

	@Override
	public void deleteProdDetail(Long id) {
		prodDetailRepository.deleteById(id);
		
	}

	@Override
	public DetailProduit updateProdDetail(DetailProduit c) {
		// TODO Auto-generated method stub
		return prodDetailRepository.save(c);
	}

	@Override
	public DetailProduit retrieveProdDetail(Long id) {
		// TODO Auto-generated method stub
		return prodDetailRepository.findById(id).orElse(null);
	}
	

}
