package com.project.turistae.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.turistae.entities.Blog;
import com.project.turistae.entities.Turismo;
import com.project.turistae.entities.Turismo;
import com.project.turistae.repositories.TurismoRepository;

@RestController
@RequestMapping(value = "/turismo")
public class TurismoController {

	private static String caminhoImagens = "src/main/resources/imagens/";
	
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
	public ResponseEntity<Boolean> insert(@RequestBody Turismo turismo, @RequestParam("file") MultipartFile arquivo) throws Exception {
		try {
			
			if (!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths.get(caminhoImagens+arquivo.getOriginalFilename());
				Files.write(caminho, bytes);
			}
			
			turismo.setImagem(arquivo.getOriginalFilename());
			
			Turismo result = repository.saveAndFlush(turismo);
			return ResponseEntity.ok().body(true);

		} catch (Exception e) {
			throw new Exception("Erro cadastrar Turismo. Causa do erro: " + e.getMessage());
		}

	}
	
	@PutMapping("uploadImagem/{idTurismo}")
	public ResponseEntity<Boolean> insertImagem(@PathVariable Long idTurismo, @RequestParam("file") MultipartFile arquivo) throws Exception {
		
		Turismo turismo = new Turismo();
		
		try {
			
	
				if (repository.findById(idTurismo).isEmpty()) {
					return ResponseEntity.ok().body(false);
					
				} else {
					turismo = repository.getById(idTurismo);
					
					
					if(turismo.getImagem() != "" || turismo.getImagem() != null) {
						Path caminhoAntigo = Paths.get(caminhoImagens+turismo.getImagem());
						Files.delete(caminhoAntigo);
					}
					
					byte[] bytes = arquivo.getBytes();
					Path caminho = Paths.get(caminhoImagens+arquivo.getOriginalFilename());
					Files.write(caminho, bytes);
					turismo.setImagem(arquivo.getOriginalFilename());
					repository.saveAndFlush(turismo);
					return ResponseEntity.ok().body(true);
					
				}


		} catch (Exception e) {
			throw new Exception("Erro cadastrar Turismo. Causa do erro: " + e.getMessage());
		}

	}

	// Deletar por ID
	@DeleteMapping("/{idTurismo}")
	public ResponseEntity<Boolean> removerPermissao(@PathVariable Long idTurismo) throws Throwable {

		try {
			if (repository.findById(idTurismo).isEmpty()) {
				return ResponseEntity.ok().body(false);
			} else {
				repository.deleteById(idTurismo);
				return ResponseEntity.ok().body(true);
			}
		} catch (Exception e) {
			throw new Exception("Erro deletar. Causa do erro: " + e.getMessage());
		}
	}

	// Alterar por ID
	@PutMapping("/{idTurismo}")
	public ResponseEntity<Boolean> alterar(@PathVariable Long idTurismo, @RequestBody Turismo turismo) throws Exception {
		turismo.setID_Turismo(idTurismo);
		
		try {
			
			if (repository.findById(idTurismo).isEmpty()) {
				return ResponseEntity.ok().body(false);
			} else {
				repository.save(turismo);
				return ResponseEntity.ok().body(true);
			}
		} catch (Exception e) {
			throw new Exception("Erro ao editar tursimo. Causa do erro: " + e.getMessage());
		}

	}
	
	// Retorna Imagem
		@GetMapping("/conteudo/MostraImagem/{imagem}")
		@ResponseBody
		public byte[] retornaImagem(@PathVariable("imagem") String imagem) throws IOException {
			File imagemArquivo = new File(caminhoImagens + imagem);
			if (imagem != null || imagem.trim().length() > 0) {
				return Files.readAllBytes(imagemArquivo.toPath());		
			}
			return null;
		}
		
		

}
