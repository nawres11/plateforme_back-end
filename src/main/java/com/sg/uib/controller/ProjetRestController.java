package com.sg.uib.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.uib.model.Projet;
import com.sg.uib.service.ProjectService;


@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ProjetRestController {

    @Autowired
    private ProjectService projectService;

	@GetMapping("/projects/count")
	public long countProjects() {
		return projectService.count();
	}

    @GetMapping("/projects")
    public List<Projet> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{id}")
    public Projet getProjectById(@PathVariable("id") long id) {
        return projectService.getProjectById(id);
    }


}
