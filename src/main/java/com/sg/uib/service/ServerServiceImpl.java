package com.sg.uib.service;

import com.sg.uib.dto.ServerCreationFormDto;
import com.sg.uib.model.*;
import com.sg.uib.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public long count() {
        return this.serverRepository.count();
    }

    @Override
    public List<Serveur> getAllServers() {

        return serverRepository.findAll();
    }

    @Override
    public void updateServer(Serveur serverDetails, Long id) {
        Serveur server = serverRepository.findById(id).get();
        System.out.println("====================");
        System.out.println(serverDetails.getId_serveur());
        System.out.println(serverDetails.getIntitule());
        System.out.println(serverDetails.getPort());
        System.out.println("====================");
        // ------------------------------------------
        server.setId_serveur(serverDetails.getId_serveur());
        server.setIntitule(serverDetails.getIntitule());
        server.setPort(serverDetails.getPort());
        server.setStatut(serverDetails.getStatut());
        server.setType(serverDetails.getType());
        server.setUrl(serverDetails.getUrl());

        serverRepository.save(server);
    }

    @Override
    public Serveur addServer(ServerCreationFormDto server) {
        Serveur newServeur = new Serveur();

        newServeur.setIntitule(server.getIntitule());
        newServeur.setPort(server.getPort());
        newServeur.setUrl(server.getUrl());
        newServeur.setType(server.getType());
        newServeur.setStatut(server.getStatut());

        return serverRepository.save(newServeur);
    }

    @Override
    public Serveur getServerById(Long id) throws ResponseStatusException {
        return serverRepository.findById(id).orElseThrow(() ->
            new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            )
        );
    }
}
