package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table( name = "Client")
public class Client implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idClient")
	private Long idClient; // Clé primaire
	private String nom;
	private String prenom;
	private String email;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Enumerated(EnumType.STRING)
	private Profession profession;
	@Enumerated(EnumType.STRING)
	private CategorieClient categorieClient;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture> factures;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public CategorieClient getCategorieClient() {
		return categorieClient;
	}

	public void setCategorieClient(CategorieClient categorieClient) {
		this.categorieClient = categorieClient;
	}

	public Set<Facture> getFactures() {
		return factures;
	}

	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	
	
}
