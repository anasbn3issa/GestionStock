	package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Produit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit; // Clé primaire
	@OneToOne
    @JoinColumn(name = "idDetailProduit")
	@NonNull
	private DetailProduit detailProduit;
	@NonNull
	private String code;
	@NonNull
	private String libelle;
	@NonNull
	private float prixUnitaire;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idStock")
    private Stock stock;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name="idRayon")
    private Rayon rayon;
	
	@OneToMany(mappedBy="produit")
	@JsonIgnore
	private Set<DetailFacture> factDetails;
	
	@NotNull
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Fournisseur> fournisseurs;

	
	
}
