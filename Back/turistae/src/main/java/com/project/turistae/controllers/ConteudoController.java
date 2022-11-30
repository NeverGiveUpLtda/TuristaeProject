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

import com.project.turistae.entities.Conteudo;
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
	
	@GetMapping("/{idConteudo}")
	public ResponseEntity<Conteudo> findById(@PathVariable Long idConteudo) {
		Conteudo conteudo = repository.findById(idConteudo).get();
		return ResponseEntity.ok().body(conteudo);	
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insert(@RequestBody Conteudo conteudo) throws Exception{
		try {
			
			Conteudo result = repository.save(conteudo);
			return ResponseEntity.ok().body(true);
			
		} catch (Exception e) {
			throw new Exception("Erro cadastrar Conteudo. Causa do erro: " + e.getMessage());
		}
		

	}	
	
	
	//Deletar por ID
		@DeleteMapping("/{idConteudo}")
		public ResponseEntity<Boolean> removerPermissao(@PathVariable Long idConteudo) throws Throwable{
			
			try {
				if(repository.findById(idConteudo).isEmpty()){
					return ResponseEntity.ok().body(false);
				}
				else {
					repository.deleteById(idConteudo);
					return ResponseEntity.ok().body(true);
				}
			} catch (Exception e) {
				throw new Exception("Erro deletar. Causa do erro: " + e.getMessage());
			}
		}
	
}
