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
public class Facture implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idFacture; // Clé primaire
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private boolean active;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailFacture> factDetails;
	
	@ManyToOne
	@JoinColumn(name="idClient")
    private Client client;

	
	
}
