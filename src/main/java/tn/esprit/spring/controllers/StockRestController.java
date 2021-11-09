package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.stock.StockServiceImpl;

@RestController
@RequestMapping("/stock")
@Api(tags = "Stock managment")
public class StockRestController {

	@Autowired
	StockServiceImpl stockService;

	// http://localhost:8089/SpringMVC/stock/retrieve-all-stock
	@GetMapping("/retrieve-all-stock")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des stock")
	public List<Stock> getStock() {
		List<Stock> listStock = stockService.retrieveAllStock();
		return listStock;
	}

	// http://localhost:8089/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	@ApiOperation(value = "permet d'ajouter un stock")
	public Stock addStock(@RequestBody Stock c) {
		Stock stock = stockService.addStock(c);
		return stock;
	}

	// http://localhost:8089/SpringMVC/stock/retrieve-stock/3
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	@ApiOperation(value = "Permet de récuperer un stock avec son id")
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}
}
