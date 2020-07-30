package com.sg.uib.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
public class Flux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_flux;
    @NotNull
    private String type_flux;
    @NotNull
    private String cadre;
    @NotNull
    private String statut;
    @NotNull
    private String dateOuverture;
    @NotNull
    private int port;
    @NotNull
    private String adresse_source;
    @NotNull
    private String adresse_destinataire;
    @NotNull
    private int duree;
    @NotNull
    private String natureEchange;


    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_serveur")
    @JsonIgnore
    private Serveur server;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = " id_projet")
    @JsonIgnore
    private Projet projet;


    public Flux() {
    }

    public Flux(int id_flux, String type_flux, String cadre, String statut, String dateOuverture, int port,
                String adresse_source, String adresse_destinataire, int duree, String natureEchange, Serveur server, Projet projet) {

        super();
        this.id_flux = id_flux;
        this.type_flux = type_flux;
        this.cadre = cadre;
        this.statut = statut;
        this.dateOuverture = dateOuverture;
        this.port = port;
        this.adresse_source = adresse_source;
        this.adresse_destinataire = adresse_destinataire;
        this.duree = duree;
        this.natureEchange = natureEchange;
        this.server = server;
        this.projet = projet;
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


    public String getCadre() {
        return cadre;
    }

    public void setCadre(String cadre) {
        this.cadre = cadre;
    }


    public String getStatut() {
        return statut;
    }


    public void setStatut(String statut) {
        this.statut = statut;
    }


    public String getDateOuverture() {
        return dateOuverture;
    }


    public void setDateOuverture(String dateOuverture) {
        this.dateOuverture = dateOuverture;
    }


    public String getNatureEchange() {
        return natureEchange;
    }

    public void setNatureEchange(String natureEchange) {
        this.natureEchange = natureEchange;
    }


    public Projet getProjet() {
        return projet;
    }


    public void setProjet(Projet projet) {
        this.projet = projet;
    }


    public Serveur getServer() {
        return server;
    }


    public void setServer(Serveur server) {
        this.server = server;
    }


}

