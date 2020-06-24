package com.sg.uib.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
public class Flux {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	   
	  @Column(unique = true)
	  @NotNull
	  private int id_flux;
	  @NotNull
	  private String type_flux;
	  @NotNull
	  private int port;
	  @NotNull
	  private String adresse_source;
	  @NotNull
	  private String adresse_destinataire;
	  @NotNull
	  private int duree;
	  @NotNull
	  private int dateOuverture;
	  @NotNull
	  private String natureEchange;
	  @ManyToOne(fetch = FetchType.EAGER, optional = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JoinColumn(name = "id_serveur", nullable = false)
	  private Serveur server;
	  
	  
	  
	public Flux() {}	
	
	

	public Flux(int id_flux, String type_flux, int port, String adresse_source, String adresse_destinataire, int duree,
			int dateOuverture, String natureEchange) {
		super();
		this.id_flux = id_flux;
		this.type_flux = type_flux;
		this.port = port;
		this.adresse_source = adresse_source;
		this.adresse_destinataire = adresse_destinataire;
		this.duree = duree;
		this.dateOuverture = dateOuverture;
		this.natureEchange = natureEchange;
	}


	public int getId_flux() {
		return id_flux;
	}
	public void setId_flux(int id_flux) {
		this.id_flux = id_flux;
	}
	public String getType_flux() {
		return type_flux;
	}
	public void setType_flux(String type_flux) {
		this.type_flux = type_flux;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getAdresse_source() {
		return adresse_source;
	}
	public void setAdresse_source(String adresse_source) {
		this.adresse_source = adresse_source;
	}
	public String getAdresse_destinataire() {
		return adresse_destinataire;
	}
	public void setAdresse_destinataire(String adresse_destinataire) {
		this.adresse_destinataire = adresse_destinataire;
	}
	
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getDateOuverture() {
		return dateOuverture;
	}



	public void setDateOuverture(int dateOuverture) {
		this.dateOuverture = dateOuverture;
	}



	public String getNatureEchange() {
		return natureEchange;
	}
	public void setNatureEchange(String natureEchange) {
		this.natureEchange = natureEchange;
	}



	public Serveur getServer() {
		return server;
	}



	public void setServer(Serveur server) {
		this.server = server;
	}



	
	

}

