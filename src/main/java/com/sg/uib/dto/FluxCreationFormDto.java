package com.sg.uib.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FluxCreationFormDto {
    private String type_flux;
    private String cadre;
    private String statut;
    private String dateOuverture;
    private int port;
    private String adresse_source;
    private String adresse_destinataire;
    private int duree;
    private String natureEchange;
    private int periodicite;
    private String  description;
 
    private Long id_serveur;
    private Long id_projet;

    public String getType_flux() {
        return type_flux;
    }

    public String getCadre() {
        return cadre;
    }

    public String getStatut() {
        return statut;
    }

    public String getDateOuverture() {
        return dateOuverture;
    }

    public int getPort() {
        return port;
    }

    public String getAdresse_source() {
        return adresse_source;
    }

    public String getAdresse_destinataire() {
        return adresse_destinataire;
    }

    public int getDuree() {
        return duree;
    }

    
    public int getPeriodicite() {
		return periodicite;
	}

	public String getDescription() {
		return description;
	}

	public String getNatureEchange() {
        return natureEchange;
    }

    public Long getId_serveur() {
        return id_serveur;
    }

    public Long getId_projet() {
        return id_projet;
    }
}
