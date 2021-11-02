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
@RequiredArgsConstructor
public class Produit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit; // Clé primaire
	@OneToOne
    @JoinColumn(name = "idDetailProduit")
	private DetailProduit detailProduit;
	private String code;
	private String libelle;
	private float prixUnitaire;
	
	@ManyToOne
	@JoinColumn(name="idStock")
    private Stock stock;
	
	@ManyToOne
    @JoinColumn(name="idRayon")
    private Rayon rayon;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<DetailFacture> factDetails;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;

	
	
}
