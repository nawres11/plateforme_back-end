package com.sg.uib.repository;

import com.sg.uib.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FluxRepository extends JpaRepository<Flux, Long> {
			@Query(value = "SELECT * FROM `flux` WHERE id_serveur= ?", nativeQuery = true)
			List<Flux> findByServer(Long id_serveur);
		}

