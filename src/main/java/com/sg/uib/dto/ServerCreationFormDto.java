package com.sg.uib.dto;

import java.util.ArrayList;

public class ServerCreationFormDto {
    private Long id_serveur;
    private String intitule;
    private int port;
    private String url;
    private String type;
    private String statut;
    private ArrayList<Long> projects;
    private ArrayList<Long> fluxs;

    public String getIntitule() {
        return intitule;
    }

    public int getPort() {
        return port;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getStatut() {
        return statut;
    }
}
