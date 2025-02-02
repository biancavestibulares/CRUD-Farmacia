package com.generation.farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.farmacia.model.Categoria;
import com.generation.farmacia.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias") //Endpoint http://localhost:8080/categorias
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	//Import da interface
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//Rastreando todos os valores da tabela
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	//Rastreando os valores pelo ID
	@GetMapping("/buscarPorId/{id}") //Endpoint http://localhost:8080/categorias/buscarPorId/{id}
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		
		return categoriaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	//Rastreando os valores pela descrição
	@GetMapping("/buscarPorDescricao/{descricaoCategoria}") //Endpoint http://localhost:8080/categorias/buscarPorDescricao/{descricaoCategoria}
	public ResponseEntity<List<Categoria>> getByTitle(@PathVariable String descricaoCategoria){
		
		return ResponseEntity.ok(categoriaRepository.findAllByDescricaoCategoriaContainingIgnoreCase(descricaoCategoria));
	}
	
	//Adicionando valores a tabela
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	//Atualizando os dados da tabela a partir do ID
	@PutMapping 
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria){
		
		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
						.body(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	//Deletando valores pelo ID
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if(categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		categoriaRepository.deleteById(id);
	}
	
}
