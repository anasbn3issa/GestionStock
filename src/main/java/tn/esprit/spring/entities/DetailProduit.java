package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class DetailProduit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idDetailProduit; // Clé primaire
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date dateDernièreModification;
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;
	
	@OneToOne(mappedBy = "detailProduit")
    private Produit produit;

	public Long getIdDetailProduit() {
		return idDetailProduit;
	}

	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDernièreModification() {
		return dateDernièreModification;
	}

	public void setDateDernièreModification(Date dateDernièreModification) {
		this.dateDernièreModification = dateDernièreModification;
	}

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	

}
