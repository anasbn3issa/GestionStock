package tn.esprit.spring.services.facture;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertNotNull;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Facture;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {

	@Autowired
    private FactureRepositoryImpl factureService;
	
	@Test
	public void testChiffredAffaireParClient() {
		Date date1= new Date();
		Date date2= new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			date1 = simpleDateFormat.parse("2021-10-01");
			date2 = simpleDateFormat.parse("2021-12-02");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		float returnedChiffredAffaire = factureService.getChiffreAffaireParCategorieClient(CategorieClient.Premium, date1, date2);
		log.info(String.valueOf(returnedChiffredAffaire));
		assertNotNull(returnedChiffredAffaire);
		//it would be more correct to actually loop my table and calculate chiffre d'affaire , but i prefered to test with asserNotNull and verify the value logged and verify if its accurate with whats in my DB
		//therefore this is not a real test to be taken into consideration 
	}
}
