package com.sg.uib.service;

import com.sg.uib.model.*;
import com.sg.uib.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServerServiceImpl implements ServerService{
	
	 @Autowired
	    private ServerRepository serverRepository;
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
			System.out.println(serverDetails.getProjet().size());
			System.out.println("====================");
			// ------------------------------------------
	        server.setId_serveur(serverDetails.getId_serveur());
	        server.setIntitule(serverDetails.getIntitule());
	        server.setPort(serverDetails.getPort());
	        server.setProjet(serverDetails.getProjet());
	        server.setStatut(serverDetails.getStatut());
	        server.setType(serverDetails.getType());
	        server.setUrl(serverDetails.getUrl());

	        serverRepository.save(server);
	    }

	    @Override
	    public Serveur addServer(Serveur server ) {
	        return serverRepository.saveAndFlush(server);
	    }

	    @Override
	    public Serveur getServerById(Long id) {
	        return serverRepository.findById(id).get();
	    }

}
