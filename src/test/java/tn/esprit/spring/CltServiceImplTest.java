package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.client.ClientServiceImpl;
import tn.esprit.spring.services.client.CltServiceImpl;
import tn.esprit.spring.services.stock.StkServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CltServiceImplTest {

	@Autowired
    private CltServiceImpl cltServiceImpl;
    
    @Test
    public void testFetchClient() {
        try {
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1995");
	        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1995");  
	        Date date3=new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1995");  
	        Client c1 = new Client();
	        c1.setDateNaissance(date3);
	        cltServiceImpl.addClient(c1);
	        
	        List<Client> clients = cltServiceImpl.retrieveClientsByProfession(date1, date2);
	        assertNotNull(clients.get(0));
	        assertTrue(clients.size()>0);
	        cltServiceImpl.deleteClient(c1.getIdClient());
	        
	        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    
    }
}