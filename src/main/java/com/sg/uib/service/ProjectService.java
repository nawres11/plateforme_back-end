package com.sg.uib.service;

import java.util.List;

import com.sg.uib.model.Projet;


public interface ProjectService {
    public long count();

    public List<Projet> getAllProjects();

    public Projet getProjectById(Long id);
}

