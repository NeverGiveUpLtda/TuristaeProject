package com.project.turistae.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.turistae.entities.Visitante;
import com.project.turistae.repositories.VisitanteRepository;

@RestController
@RequestMapping(value = "/visitantes")
public class VisitanteController {
	
	@Autowired
	private VisitanteRepository repository;

	@GetMapping
	public ResponseEntity<List<Visitante>> findAll() {
	    List<Visitante> result = repository.findAll();
	    
	    return ResponseEntity.ok(result);
	}

	

}
