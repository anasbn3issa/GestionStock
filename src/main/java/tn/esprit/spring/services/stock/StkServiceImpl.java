package tn.esprit.spring.services.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repositories.ClientRepository;
import tn.esprit.spring.repositories.StockRepository;
import tn.esprit.spring.services.client.ClientServiceImpl;

@Service
@Slf4j
public class StkServiceImpl implements StockServiceImpl{
	
	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public List<Stock> retrieveAllStock() {
		// TODO Auto-generated method stub
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		log.info("stock to be added "+s);
		return stockRepository.save(s);
	}

	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		log.info("stock to be deleted id: "+id);
		stockRepository.deleteById(id);
	}

	@Override
	public Stock updateStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		return stockRepository.findById(id).orElse(null);
	}

	
}
