package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import antlr.collections.List;

@Entity
public class Stock implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idStock; // Clé primaire
	private Integer qte;
	private Integer qteMin;
	private String libelleStock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produits;
	// Constructeur et accesseurs (getters) et mutateurs (setters) }

	
	
	public Long getIdStock() {
		return idStock;
	}

	public Stock(Integer qte, Integer qteMin, String libelleStock) {
		super();
		this.qte = qte;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
	}

	public Stock() {
		super();
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Integer getQteMin() {
		return qteMin;
	}

	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}

	public String getLibelleStock() {
		return libelleStock;
	}

	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
	
}
