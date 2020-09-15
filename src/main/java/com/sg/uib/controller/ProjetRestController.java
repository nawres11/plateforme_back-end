package com.sg.uib.controller;

import java.util.List;

import javax.validation.Valid;

import com.sg.uib.dto.ProjectCreationFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sg.uib.model.Projet;
import com.sg.uib.service.ProjectService;


@RestController
@CrossOrigin("*")
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

    @PostMapping("/projects")
    public Projet addProjects(@RequestBody ProjectCreationFormDto projet) {
        return projectService.addProject(projet);
    }

    @GetMapping("/projects/{id}")
    public Projet getProjectById(@PathVariable("id") Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/projects/{id}")
    public Projet updateProjectById(@PathVariable("id") Long id, @RequestBody ProjectCreationFormDto projet) {
        return projectService.updateProject(id, projet);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProjectById(@PathVariable("id") Long id) {
        projectService.removeProject(id);
    }
}
