package com.sg.uib.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String statut;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_flux")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
//     @JsonIgnoreProperties(value = {"flux"}, allowSetters = true)
    private List<Flux> flux;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_projet")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
//     @JsonIgnoreProperties(value = {"projet"}, allowSetters = true)
    private List<Projet> projet;


    public Serveur() {
        super();
    }

    public Serveur(Long id_serveur, String intitule, int port, String url, String type, String statut,
                   List<Projet> projet) {
        super();
        this.id_serveur = id_serveur;
        this.intitule = intitule;
        this.port = port;
        this.url = url;
        this.type = type;
        this.statut = statut;
        this.projet = projet;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


    public List<Projet> getProjet() {
        return projet;
    }

    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }

    public List<Flux> getFlux() {
        return flux;
    }

    public void setFlux(List<Flux> flux) {
        this.flux = flux;
    }


}

