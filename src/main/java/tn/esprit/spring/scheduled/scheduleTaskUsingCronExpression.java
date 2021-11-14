package tn.esprit.spring.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repositories.StockRepository;
import tn.esprit.spring.services.stock.StkServiceImpl;
import tn.esprit.spring.services.stock.StockServiceImpl;
@Slf4j

public class scheduleTaskUsingCronExpression {

	@Autowired
	StockRepository stockRepo;
	
	@Scheduled(cron = "*/20 * * * * *")
	public void scheduleTaskUsingCronExpression() {
	 
		log.info("stock check");
		List<Stock> currentStock = stockRepo.retrieveStockProcheDeRupture();
		for(Stock s:currentStock) {
				log.info(s.getLibelleStock()+"needs more");
		}
	   

}

}