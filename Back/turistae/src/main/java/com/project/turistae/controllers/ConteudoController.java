package com.project.turistae.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.turistae.entities.Conteudo;
import com.project.turistae.repositories.ConteudoRepository;

@RestController
@RequestMapping(value = "/conteudo")
public class ConteudoController {
	
	@Autowired
	private ConteudoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Conteudo>> findAll() {
	    List<Conteudo> result = repository.findAll();
	    
	    return ResponseEntity.ok(result);	

}
}
