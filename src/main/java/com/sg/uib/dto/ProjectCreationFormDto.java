package com.sg.uib.dto;

import com.sg.uib.model.Serveur;

import javax.persistence.*;

public class ProjectCreationFormDto {
    private Long id_projet;
    private String intitule_projet;
    private String dateCreation;
    private String type_projet;

    private Long id_server;

    public Long getId_projet() {
        return id_projet;
    }

    public String getIntitule_projet() {
        return intitule_projet;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getType_projet() {
        return type_projet;
    }

    public Long getId_server() {
        return id_server;
    }
}
