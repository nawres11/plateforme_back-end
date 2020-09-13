package com.sg.uib.service;

import java.util.List;

import com.sg.uib.dto.ProjectCreationFormDto;
import com.sg.uib.model.Serveur;
import com.sg.uib.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sg.uib.model.Projet;
import com.sg.uib.repository.ProjectRepository;
import org.springframework.web.server.ResponseStatusException;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepository projetRepository;
    @Autowired
    private ServerRepository serverRepository;

    @Override
    public long count() {
        return this.projetRepository.count();
    }

    @Override
    public List<Projet> getAllProjects() {

        return projetRepository.findAll();
    }

    @Override
    public Projet getProjectById(Long id) {
        return projetRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                )
        );
    }

    @Override
    public Projet addProject(ProjectCreationFormDto projet) {
        Projet newProject = new Projet();

        newProject.setIntitule_projet(projet.getIntitule_projet());
        newProject.setDateCreation(projet.getDateCreation());
        newProject.setType_projet(projet.getType_projet());

        Long relatedServerId = projet.getId_server();

        if (relatedServerId == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "non-coherent data"
            );
        }

        Serveur relatedServer = serverRepository.findById(relatedServerId).orElseThrow(
                () -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
                )
        );

        newProject.setServer(relatedServer);

        return projetRepository.save(newProject);
    }

    @Override
    public Projet updateProject(Long id, ProjectCreationFormDto newProject) {
        Projet projet = projetRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                )
        );

        if (newProject.getId_server() != null) {
            Serveur relatedServer = serverRepository.findById(newProject.getId_server()).orElseThrow(
                    () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "entity not found"
                    )
            );

            projet.setServer(relatedServer);
        }

        if (newProject.getDateCreation() != null) {
            projet.setDateCreation(newProject.getDateCreation());
        }

        if (newProject.getIntitule_projet() != null) {
            projet.setIntitule_projet(newProject.getIntitule_projet());
        }

        if (newProject.getType_projet() != null) {
            projet.setType_projet(newProject.getType_projet());
        }

        return projet;
    }

    @Override
    public void removeProject(Long id) {
        projetRepository.deleteById(id);
    }
}