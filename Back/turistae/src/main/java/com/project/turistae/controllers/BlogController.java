package com.project.turistae.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.turistae.entities.Blog;
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
	
	@GetMapping("/{idBlog}")
	public ResponseEntity<Blog> findById(@PathVariable Long idBlog) {
		Blog blog = repository.findById(idBlog).get();
		return ResponseEntity.ok().body(blog);	
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insert(@RequestBody Blog blog) throws Exception{
		try {
			
			Blog result = repository.save(blog);
			return ResponseEntity.ok().body(true);
			
		} catch (Exception e) {
			throw new Exception("Erro cadastrar Blog. Causa do erro: " + e.getMessage());
		}
		

	}	
	
	
	//Deletar por ID
		@DeleteMapping("/{idBlog}")
		public ResponseEntity<Boolean> removerPermissao(@PathVariable Long idBlog) throws Throwable{
			
			try {
				if(repository.findById(idBlog).isEmpty()){
					return ResponseEntity.ok().body(false);
				}
				else {
					repository.deleteById(idBlog);
					return ResponseEntity.ok().body(true);
				}
			} catch (Exception e) {
				throw new Exception("Erro deletar. Causa do erro: " + e.getMessage());
			}
		}
	


}
