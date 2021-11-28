package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.produit.ProduitServiceImpl;


@RestController
@RequestMapping("/produit")
@Api(tags= "Produit managment")
public class ProduitRestController {
	@Autowired 
	ProduitServiceImpl produitService;
	// http://localhost:8089/SpringMVC/produit/retrieve-all-products
		@GetMapping("/retrieve-all-products")
		@ResponseBody
		@ApiOperation(value ="Récupérer la liste des produits")
		public List<Produit> getProduits() {
			List<Produit> listProduits = produitService.retrieveAllProduits();
			return listProduits;
		}

		//http://localhost:8089/SpringMVC/produit/add-product
			@PostMapping("/add-product")
			@ResponseBody
			@ApiOperation(value ="permet d'ajouter un produit")
			public Produit addProduit(@RequestBody Produit c) {
				long x=2;
				Produit product = produitService.addProduit(c,x,x);
				return product;
			}
			//http://localhost:8089/SpringMVC/produit/retrieve-produit/3
				@GetMapping("/retrieve-produit/{produit-id}")
				@ResponseBody
				@ApiOperation(value ="Permet de récuperer un produit avec son id")
				public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
					return produitService.retrieveProduit(produitId);
				}

				//http://localhost:8089/SpringMVC/produit/assignfournisseurproduit/3/2
				@PostMapping("/assignfournisseurproduit/{produit-id}/{fournisseur-id}")
				@ResponseBody
				@ApiOperation("assigns a fournisseur to a produit")
				public void assignFournisseurToProduit(@PathVariable("produit-id") Long produitId,@PathVariable("fournisseur-id") Long fournisseurId) {
					produitService.assignFournisseurToProduit(produitId,fournisseurId);
				}
				
				//http://localhost:8089/SpringMVC/produit/assignstockproduit/3/2
				@PostMapping("/assignstockproduit/{produit-id}/{stock-id}")
				@ResponseBody
				@ApiOperation("assigns a stock to a produit")
				public void assignStockToProduit(@PathVariable("produit-id") Long produitId,@PathVariable("stock-id") Long stockId) {
					produitService.assignProduitToStock(produitId, stockId);
				}
				
				//http://localhost:8089/SpringMVC/produit/retrieve-produit/3
				@GetMapping("/revenubrut/{produit-id}")
				@ResponseBody
				@ApiOperation(value ="Permet de calculer le revenu brut d'un produit entre deux dates")
				public float RevenuBrutProduit(@PathVariable("produit-id") Long produitId) {
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
					return produitService.getRevenuBrutProduit(produitId,date1,date2);
				}
}
