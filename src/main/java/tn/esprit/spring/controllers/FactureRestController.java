package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.services.facture.FactureRepositoryCustom;
import tn.esprit.spring.services.facture.FactureRepositoryImpl;
@Slf4j
@RestController
@RequestMapping("/facture")
@Api(tags= "Facture managment")
public class FactureRestController {
	@Autowired
	FactureRepositoryImpl factureService;
	// http://localhost:8089/SpringMVC/facture/get-facture-by-client/1
	@GetMapping("/get-facture-by-client/{idClient}")
	@ResponseBody
	@ApiOperation(value = "permet de récuperer la liste des facture dun client spécifique")
	public List<Facture>getFactureByClient(@PathVariable("idClient")Long idClient) {
		return factureService.getFactureByClient(idClient);
		
	}
	
	@PostMapping("/add-facture")
	@ResponseBody
	@ApiOperation(value ="permet d'ajouter une facture")
	public Facture addFacture(Facture f) {
		return factureService.addFacture(f);
	}
	
	@GetMapping("/get-chiffre-d-affaire/{categorieClient}/")
	@ResponseBody
	@ApiOperation(value = "permet de récuperer le chiffre d'affaire par catégorie client entre 2 dates.")
	public float getChiffreDaffaireParCategorieClient(@PathVariable("categorieClient")String categorieClient) {
		return factureService.getChiffreAffaireParCategorieClient(CategorieClient.Premium, null, null);
		
	}
	
	
}
