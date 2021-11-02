package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
public class Stock implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idStock; // Clé primaire
	private Integer qte;
	private Integer qteMin;
	private String libelleStock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produits;
	

	
	
}
