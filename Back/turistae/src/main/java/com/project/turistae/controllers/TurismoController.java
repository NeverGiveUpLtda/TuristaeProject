package com.project.turistae.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.turistae.entities.Turismo;
import com.project.turistae.repositories.TurismoRepository;

@RestController
@RequestMapping(value = "/turismo")
public class TurismoController {


	@Autowired
	private TurismoRepository repository;

	@GetMapping
	public ResponseEntity<List<Turismo>> findAll() {
	    List<Turismo> result = repository.findAll();
	    
	    return ResponseEntity.ok(result);
	}
}
