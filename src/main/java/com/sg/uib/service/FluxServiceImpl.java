package com.sg.uib.service;


import com.sg.uib.dto.FluxCreationFormDto;
import com.sg.uib.model.*;
import com.sg.uib.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@Transactional
public class FluxServiceImpl implements FluxService {


    @Autowired
    private FluxRepository fluxRepository;
    @Autowired
    private ServerRepository serverRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public long count() {
        return this.fluxRepository.count();
    }

    @Override
    public List<Flux> getAllFluxs() {
        return fluxRepository.findAll();
    }

    @Override
    public Flux addFlux(FluxCreationFormDto flux) {
        Flux newFlux = new Flux();

        newFlux.setAdresse_source(flux.getAdresse_source());
        newFlux.setAdresse_destinataire(flux.getAdresse_destinataire());
        newFlux.setPort(flux.getPort());
        newFlux.setCadre(flux.getCadre());
        newFlux.setDateOuverture(flux.getDateOuverture());
        newFlux.setType_flux(flux.getType_flux());
        newFlux.setNatureEchange(flux.getNatureEchange());
        newFlux.setStatut(flux.getStatut());
        newFlux.setValidated(false);

        if (flux.getId_serveur() != null) {
            Serveur newServer = serverRepository.getOne(flux.getId_serveur());
            newFlux.setServer(newServer);
        }

        if (flux.getId_projet() != null) {
            newFlux.setProjet(
                    projectRepository.getOne(flux.getId_projet())
            );
        }

        return fluxRepository.save(newFlux);
    }

    @Override
    public List<Serveur> getAllServers() {
        return serverRepository.findAll();
    }

    @Override
    public Flux getFluxById(Long id) {
        return fluxRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                )
        );
    }

    @Override
    public List<Flux> findByServer(Long id_serveur) {

        return fluxRepository.findByServer(id_serveur);
    }

    @Override
    public Flux validateFluxById(Long id) {
        Flux flux = fluxRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                )
        );
        flux.setValidated(true);

        return fluxRepository.save(flux);
    }
}
