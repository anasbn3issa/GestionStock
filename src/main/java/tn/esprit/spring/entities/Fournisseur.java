package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Fournisseur implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFournisseur; // Clé primaire
	private String code;
	private String libelle;
	
	// Constructeur et accesseurs (getters) et mutateurs (setters) }
}
