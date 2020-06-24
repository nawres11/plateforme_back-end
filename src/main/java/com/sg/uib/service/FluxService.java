package com.sg.uib.service;

import com.sg.uib.model.*;

import java.util.List;

public interface FluxService {

	  public List<Flux> getAllFluxs();
	    public Flux addFlux(Flux flux, Long id_serveur);
	    public Flux getFluxById(Long id);
	    public List<Serveur> getAllServers();
	    public List<Flux> findByServer(Long id_serveur);
	}


