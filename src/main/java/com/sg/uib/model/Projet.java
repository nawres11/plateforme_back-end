package com.sg.uib.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class Projet {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	   
	 @Column(unique = true)
	 private int id_projet;
	 @Column(nullable = false)
     private int num_projet;
	 @Column(nullable = false)
     private String dateCreation;
	 @Column(nullable = false)
     private String type_projet;
	
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_projet")
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonIgnoreProperties(value = {"projet"}, allowSetters = true)
	 private List<Flux> flux ;
	 
	 
	 
	 

	public Projet() {
		super();
	}
	

	public Projet(int num_projet, String dateCreation, String type_projet) {
		super();
		this.num_projet = num_projet;
		this.dateCreation = dateCreation;
		this.type_projet = type_projet;
	}


	public Projet(int num_projet, String dateCreation, String type_projet, List<Flux> flux) {
		super();
		this.num_projet = num_projet;
		this.dateCreation = dateCreation;
		this.type_projet = type_projet;
		this.flux = flux;
	}

	public int getId_projet() {
		return id_projet;
	}

	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}

	public int getNum_projet() {
		return num_projet;
	}

	public void setNum_projet(int num_projet) {
		this.num_projet = num_projet;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getType_projet() {
		return type_projet;
	}

	public void setType_projet(String type_projet) {
		this.type_projet = type_projet;
	}

	public List<Flux> getFlux() {
		return flux;
	}

	public void setFlux(List<Flux> flux) {
		this.flux = flux;
	}
	 
	 
	 

}
