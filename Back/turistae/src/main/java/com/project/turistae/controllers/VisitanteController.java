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

import com.project.turistae.entities.Turismo;
import com.project.turistae.entities.Visitante;
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

	@GetMapping("/{idVisitante}")
	public ResponseEntity<Visitante> findById(@PathVariable Long idVisitante) {
		Visitante visitante = repository.findById(idVisitante).get();
		return ResponseEntity.ok().body(visitante);
	}

	@PostMapping
	public ResponseEntity<Boolean> insert(@RequestBody Visitante visitante) throws Exception {
		try {

			Visitante result = repository.save(visitante);
			return ResponseEntity.ok().body(true);

		} catch (Exception e) {
			throw new Exception("Erro cadastrar Visitante. Causa do erro: " + e.getMessage());
		}

	}

	// Deletar por ID
	@DeleteMapping("/{idVisitante}")
	public ResponseEntity<Boolean> removerPermissao(@PathVariable Long idVisitante) throws Throwable {

		try {
			if (repository.findById(idVisitante).isEmpty()) {
				return ResponseEntity.ok().body(false);
			} else {
				repository.deleteById(idVisitante);
				return ResponseEntity.ok().body(true);
			}
		} catch (Exception e) {
			throw new Exception("Erro deletar. Causa do erro: " + e.getMessage());
		}
	}

	// Alterar por ID
	@PutMapping("/{idVisitante}")
	public ResponseEntity<Boolean> alterar(@PathVariable Long idVisitante, @RequestBody Visitante visitante)
			throws Exception {

		try {
			if (repository.findById(idVisitante).isEmpty()) {
				return ResponseEntity.ok().body(false);
			} else {
				repository.save(visitante);
				return ResponseEntity.ok().body(true);
			}
		} catch (Exception e) {
			throw new Exception("Erro ao editar tursimo. Causa do erro: " + e.getMessage());
		}

	}

}
