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
import tn.esprit.spring.entities.Client;
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

}
