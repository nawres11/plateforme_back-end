package com.sg.uib.service;

import com.sg.uib.model.Serveur;

import java.util.List;

public interface ServerService {
	
	 public List<Serveur> getAllServers();
	    public void updateServer(Serveur server, Long id);
	    public Serveur addServer(Serveur server);
	    public Serveur getServerById(Long id);

}
