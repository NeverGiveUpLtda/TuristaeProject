package com.project.turistae.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.turistae.entities.Usuario;
import com.project.turistae.entities.Visitante;
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
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> findById(@PathVariable Long idUsuario) {
		Usuario usuario = repository.findById(idUsuario).get();
		return ResponseEntity.ok().body(usuario );	
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insert(@RequestBody Usuario usuario) throws Exception{
		try {
			
			Usuario result = repository.save(usuario);
			return ResponseEntity.ok().body(true);
			
		} catch (Exception e) {
			throw new Exception("Erro cadastrar Usuario de Projeto. Causa do erro: " + e.getMessage());
		}
		

	}	
	
	
	//Deletar por ID
		@DeleteMapping("/{idUsuario}")
		public ResponseEntity<Boolean> removerPermissao(@PathVariable Long idUsuario) throws Throwable{
			
			try {
				if(repository.findById(idUsuario).isEmpty()){
					return ResponseEntity.ok().body(false);
				}
				else {
					repository.deleteById(idUsuario);
					return ResponseEntity.ok().body(true);
				}
			} catch (Exception e) {
				throw new Exception("Erro deletar Apontamento de Projeto. Causa do erro: " + e.getMessage());
			}
		}
		
		

		// Alterar por ID
		@PutMapping("/{idUsuario}")
		public ResponseEntity<Boolean> alterar(@PathVariable Long idUsuario, @RequestBody Usuario usuario)
				throws Exception {

			try {
				if (repository.findById(idUsuario).isEmpty()) {
					return ResponseEntity.ok().body(false);
				} else {
					repository.save(usuario);
					return ResponseEntity.ok().body(true);
				}
			} catch (Exception e) {
				throw new Exception("Erro ao editar usuario. Causa do erro: " + e.getMessage());
			}

		}
	
	
	
//	@GetMapping(value = "/search-salary")
//	public ResponseEntity<Page<User>> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary, @RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
//	    Page<User> result = repository.findBySalaryBetween(minSalary, maxSalary, pageable);
//	    return ResponseEntity.ok(result);
//	}
//
	}
