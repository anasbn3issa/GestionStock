/*package tn.esprit.spring.services.produit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.repositories.ProduitRepository;
import tn.esprit.spring.services.facture.FactureServiceImplTest;
import tn.esprit.spring.services.produit.PrdServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class PrdServiceImplTest {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Test
	public void testCalculRevenuBrutProduit() {
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
		long id=1;
		float returnedRevenuBrut = produitRepository.getRevenuBrutProduit(id, date1, date2);
		log.info(String.valueOf(returnedRevenuBrut));

		assertNotNull(returnedRevenuBrut);
		
		//it would be more correct to actually loop my table and calculate revenu Brut , but i prefered to test with asserNotNull and verify the value logged and verify if its accurate with whats in my DB
				//therefore this is not a real test to be taken into consideration 

	}

}*/
