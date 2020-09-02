package com.sg.uib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sg.uib.model.Projet;
import com.sg.uib.repository.ProjectRepository;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepository projetRepository;

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
        return projetRepository.findById(id).get();
    }


}