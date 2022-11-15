package com.project.turistae.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.turistae.entities.Usuario;
import com.project.turistae.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
	    List<Usuario> result = repository.findAll();
	    
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Usuario>> findAll(Pageable pegeable) {
	    Page<Usuario> result = repository.findAll(pegeable);
	    return ResponseEntity.ok(result);
	}
	
//	@GetMapping(value = "/search-salary")
//	public ResponseEntity<Page<User>> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary, @RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
//	    Page<User> result = repository.findBySalaryBetween(minSalary, maxSalary, pageable);
//	    return ResponseEntity.ok(result);
//	}
//
	}
