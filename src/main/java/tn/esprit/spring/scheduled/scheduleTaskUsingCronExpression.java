package tn.esprit.spring.scheduled;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repositories.FactureRepository;
import tn.esprit.spring.repositories.FournisseurRepository;
import tn.esprit.spring.repositories.StockRepository;
import tn.esprit.spring.services.stock.StkServiceImpl;
import tn.esprit.spring.services.stock.StockServiceImpl;

@Slf4j
public class scheduleTaskUsingCronExpression {

	@Autowired
	StockRepository stockRepo;
	@Autowired
	FactureRepository factRepo;
	
	@Scheduled(cron = "*/20 * * * * *")
	public void scheduleTaskUsingCronExpression() {
	 
		log.info("stock check");
		List<Stock> currentStock = stockRepo.retrieveStockProcheDeRupture();
		for(Stock s:currentStock) {
				log.info(s.getLibelleStock()+"needs more");
		}
	   

}

	@Scheduled(cron= "0 0 0 1 1 *")
	public void chiffreAffaireYear() {
		 Calendar cal = Calendar.getInstance();
		 Date cdate = cal.getTime();
		 cal.add(Calendar.YEAR, -2); 
	      Date previousyear = cal.getTime();
	      log.info("chiffre d'affaire pour cette année : "+factRepo.calculChiffreAffairesBetweenTwoDates(cdate, previousyear));
	}
	
	@Scheduled(cron="0 0 0 1 0 0")
	public void chiffreAffaireMonth() {
		Calendar cal = Calendar.getInstance();
		Date cdate = cal.getTime();
		cal.add(Calendar.MONTH, -1);
		Date previousmonth = cal.getTime();
	     log.info("chiffre d'affaire pour cette année : "+factRepo.calculChiffreAffairesBetweenTwoDates(cdate, previousmonth));

	}
}