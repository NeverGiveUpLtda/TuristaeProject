package com.project.turistae.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.turistae.entities.Blog;
import com.project.turistae.entities.Turismo;
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
	
	
	@GetMapping("/{idTurismo}")
	public ResponseEntity<Turismo> findById(@PathVariable Long idTurismo) {
		Turismo turismo = repository.findById(idTurismo).get();
		return ResponseEntity.ok().body(turismo);	
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insert(@RequestBody Turismo turismo) throws Exception{
		try {
			
			Turismo result = repository.save(turismo);
			return ResponseEntity.ok().body(true);
			
		} catch (Exception e) {
			throw new Exception("Erro cadastrar Turismo. Causa do erro: " + e.getMessage());
		}
		

	}	
	
	
	//Deletar por ID
		@DeleteMapping("/{idTurismo}")
		public ResponseEntity<Boolean> removerPermissao(@PathVariable Long idTurismo) throws Throwable{
			
			try {
				if(repository.findById(idTurismo).isEmpty()){
					return ResponseEntity.ok().body(false);
				}
				else {
					repository.deleteById(idTurismo);
					return ResponseEntity.ok().body(true);
				}
			} catch (Exception e) {
				throw new Exception("Erro deletar. Causa do erro: " + e.getMessage());
			}
		}
		
		// Alterar por ID
		@PutMapping("/{idTurismo}")
		public ResponseEntity<Boolean> alterar(@PathVariable Long idTurismo, @RequestBody Turismo tursimo)
				throws Exception {

			try {
				if (repository.findById(idTurismo).isEmpty()) {
					return ResponseEntity.ok().body(false);
				} else {
					repository.save(tursimo);
					return ResponseEntity.ok().body(true);
				}
			} catch (Exception e) {
				throw new Exception("Erro ao editar tursimo. Causa do erro: " + e.getMessage());
			}

		}
		
		
}
