package com.sg.uib.service;

import com.sg.uib.dto.ServerCreationFormDto;
import com.sg.uib.model.Serveur;

import java.util.List;

public interface ServerService {

    long count();

    List<Serveur> getAllServers();

    void updateServer(Serveur server, Long id);

    Serveur addServer(ServerCreationFormDto server);

    Serveur getServerById(Long id);

}
