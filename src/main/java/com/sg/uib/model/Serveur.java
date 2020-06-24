package com.sg.uib.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@Entity
public class Serveur {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

     @Column(unique = true)
     private Long id_serveur;
     @Column(nullable = false)
     private String intitule;
     @Column(nullable = false)
     private int port;
     @Column(nullable = false)
     private String url;
     @Column(nullable = false)
     private String type;
     @Column(nullable = false)
     private String projet;
     @Column(nullable = false)
     private String statut;

     @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
     @JoinColumn(name = "id_serveur")
     @OnDelete(action = OnDeleteAction.CASCADE)
     @JsonIgnoreProperties(value = {"server"}, allowSetters = true)
     private List<Flux> flux ;




     public Serveur() {
        super();
    }

    public Serveur(String intitule, int port, String url, String type, String projet,
            String statut) {
        super();
        this.intitule = intitule;
        this.port = port;
        this.url = url;
        this.type = type;
        this.projet = projet;
        this.statut = statut;
    }



    public Long getId_serveur() {
        return id_serveur;
    }

    public void setId_serveur(Long id_serveur) {
        this.id_serveur = id_serveur;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<Flux> getFlux() {
        return flux;
    }

    public void setFlux(List<Flux> flux) {
        this.flux = flux;
    }



}

