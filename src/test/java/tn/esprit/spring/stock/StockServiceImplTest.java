package tn.esprit.spring.stock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.stock.StockServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

	@Autowired
	StockServiceImpl stockService;

	@Test
	public void testAddStock() throws ParseException {
		Stock s = new Stock();
		s.setLibelleStock("test");
		s.setQte(3);
		s.setQteMin(4);
		Stock added = stockService.addStock(s);
		assertEquals(s,added);
		stockService.deleteStock(added.getIdStock());
	}
}