package com.sg.uib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.uib.model.Projet;

public interface ProjectRepository extends JpaRepository<Projet, Long> {

    List<Projet> findAll();

    long count();
}


