package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "boutique")
@Data
public class Boutique implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Categorie categorie;
	
	@ManyToOne
	@Fetch(value=FetchMode.SELECT)
	@JoinColumn(name="id",insertable=false ,updatable=false)
    private CentreCommercial centreCommercial;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Client2> clients2;
}
