package com.sg.uib.service;

import java.util.List;

import com.sg.uib.dto.ProjectCreationFormDto;
import com.sg.uib.model.Projet;


public interface ProjectService {
    public long count();

    public List<Projet> getAllProjects();

    public Projet getProjectById(Long id);

    public Projet addProject(ProjectCreationFormDto projet);

    public Projet updateProject(Long id, ProjectCreationFormDto newProject);

    public void removeProject(Long id);
}

