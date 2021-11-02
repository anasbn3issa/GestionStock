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

	
	

}
