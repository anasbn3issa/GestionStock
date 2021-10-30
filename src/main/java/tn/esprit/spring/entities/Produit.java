	package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
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

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public DetailProduit getDetailProduit() {
		return detailProduit;
	}

	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	public Set<DetailFacture> getFactDetails() {
		return factDetails;
	}

	public void setFactDetails(Set<DetailFacture> factDetails) {
		this.factDetails = factDetails;
	}

	public Set<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	
	
}
