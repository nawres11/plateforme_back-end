package com.sg.uib.service;

import com.sg.uib.dto.FluxCreationFormDto;
import com.sg.uib.model.*;

import java.util.List;

public interface FluxService {

    public long count();

    public List<Flux> getAllFluxs();

    public Flux addFlux(FluxCreationFormDto flux);

    public Flux getFluxById(Long id);

    public List<Serveur> getAllServers();

    public List<Flux> findByServer(Long id_serveur);
    

    public void removeFlux(Long id);
}


