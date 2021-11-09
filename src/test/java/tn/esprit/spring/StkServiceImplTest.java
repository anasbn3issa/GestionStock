package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.stock.StkServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StkServiceImplTest {

	@Autowired
    private StkServiceImpl stkServiceImpl;

    @Test
    public void testAdditionner() {
        // Arrange
        final int param1 = 2;
        final int param2 = 2;
        final int expected = 4;
        
        
        // Assert
        assertEquals(expected, param1+param2);
    }
    
    @Test
    public void testAddStock() { 
    /*List<Stock> stocks = stkServiceImpl.retrieveAllStock();
    int expected=stocks.size();*/
    Stock s = new Stock();
    s.setLibelleStock("stock test");
    s.setQte(10);
    s.setQteMin(100);
    Stock savedStock= stkServiceImpl.addStock(s);
    //assertEquals(expected+1, stkServiceImpl.retrieveAllStock().size());
    assertNotNull(savedStock.getLibelleStock());
    stkServiceImpl.deleteStock(savedStock.getIdStock());
    }
    
    
    @Test
    public void testDeleteStock() {
    	Stock s = new Stock();
    	s.setLibelleStock("stock test");
        s.setQte(10);
        s.setQteMin(100);
    	Stock savedStock = stkServiceImpl.addStock(s);
        stkServiceImpl.deleteStock(savedStock.getIdStock());
        assertNull(savedStock.getLibelleStock());
    }
}