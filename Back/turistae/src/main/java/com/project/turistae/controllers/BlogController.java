package com.project.turistae.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.turistae.entities.Blog;
import com.project.turistae.repositories.BlogRepository;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {
	
	@Autowired
	private BlogRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Blog>> findAll() {
	    List<Blog> result = repository.findAll();
	    
	    return ResponseEntity.ok(result);
	}


}
