package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Rayon implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idRayon; // Clé primaire
	private String code;
	private String libelle;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> produits;
	
	// Constructeur et accesseurs (getters) et mutateurs (setters) }
}
