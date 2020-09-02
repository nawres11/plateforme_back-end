package com.sg.uib.service;


import com.sg.uib.model.*;
import com.sg.uib.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FluxServiceImpl implements FluxService {


    @Autowired
    private FluxRepository fluxRepository;
    @Autowired
    private ServerRepository serverRepository;

    @Override
    public long count() {
        return this.fluxRepository.count();
    }

    @Override
    public List<Flux> getAllFluxs() {
        return fluxRepository.findAll();
    }

    @Override
    public Flux addFlux(Flux flux) {

        return fluxRepository.save(flux);
    }

    @Override
    public List<Serveur> getAllServers() {
        return serverRepository.findAll();
    }

    @Override
    public Flux getFluxById(Long id) {
        return fluxRepository.findById(id).get();
    }

    @Override
    public List<Flux> findByServer(Long id_serveur) {

        return fluxRepository.findByServer(id_serveur);
    }
}
