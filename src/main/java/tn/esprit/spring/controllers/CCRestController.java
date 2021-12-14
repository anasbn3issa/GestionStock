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

import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Client2;
import tn.esprit.spring.services.centreCom.ICCService;

@RestController
@RequestMapping("/cc")
public class CCRestController {
	@Autowired
	ICCService ccService;
	
	@PostMapping("/ajouter-cc")
	@ResponseBody
	public void addCC(@RequestBody CentreCommercial cc) {
		ccService.ajouterCentre(cc);
	}
	@GetMapping("/list-boutiques/{id-centre}")
	@ResponseBody
	public void listBoutique(@PathVariable("id-centre") Long idCentre) {
		ccService.listedeBoutiques(idCentre);
	}
	@GetMapping("/clients-par-categorie/{categorie}")
	@ResponseBody
	public List<Client2> listeDeClientsParCategorie(@PathVariable("categorie")Categorie categorie) {
		return ccService.listeDeClientsParCategorie(categorie);
	}

}
