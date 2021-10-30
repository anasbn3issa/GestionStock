package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class DetailFacture implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDetailFacture; // Clé primaire
	private float prixTotal;
	private float montantRemise;
	private Integer qte;
	private Integer pourcentageRemise;
	
	@ManyToOne
	@JoinColumn(name="idProduit")
    private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="idFacture")
    private Facture facture;
	
}
