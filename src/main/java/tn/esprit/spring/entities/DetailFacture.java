package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
