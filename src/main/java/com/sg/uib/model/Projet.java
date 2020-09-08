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
    private Long id_projet;
    @Column(nullable = false)
    private String intitule_projet;
    @Column(nullable = false)
    private String dateCreation;
    @Column(nullable = false)
    private String type_projet;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_flux")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(value = {"flux"}, allowSetters = true)
    private List<Flux> flux;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_serveur", nullable = false)
    private Serveur server;


    public Projet() {
        super();
    }

    public Projet(String intitule_projet, String dateCreation, String type_projet, List<Flux> flux) {
        super();
        this.intitule_projet = intitule_projet;
        this.dateCreation = dateCreation;
        this.type_projet = type_projet;
        this.flux = flux;
    }

    public Projet(String intitule_projet, String dateCreation, String type_projet) {
        super();
        this.intitule_projet = intitule_projet;
        this.dateCreation = dateCreation;
        this.type_projet = type_projet;
    }

    public String getIntitule_projet() {
        return intitule_projet;
    }

    public void setIntitule_projet(String intitule_projet) {
        this.intitule_projet = intitule_projet;
    }

    public Long getId_projet() {
        return id_projet;
    }

    public void setId_projet(Long id_projet) {
        this.id_projet = id_projet;
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
