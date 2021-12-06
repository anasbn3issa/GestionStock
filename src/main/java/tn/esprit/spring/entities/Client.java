package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Client")
public class Client implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
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
	@JsonIgnore
	private Set<Facture> factures;

	
	
}
