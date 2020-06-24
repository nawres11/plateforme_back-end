package com.sg.uib.repository;

import com.sg.uib.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServerRepository extends JpaRepository<Serveur,Long> {
	
	List<Serveur> findAll();

}
