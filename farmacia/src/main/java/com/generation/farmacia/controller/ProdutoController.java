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

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos") //Endpoint http://localhost:8080/produtos
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	//Rastreando todos os valores da tabela
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){

		return ResponseEntity.ok(produtoRepository.findAll());
	}

	//Rastreando os valores pelo ID
	@GetMapping("/buscarPorId/{id}") //Endpoint http://localhost:8080/categorias/buscarPorId/{id}
	public ResponseEntity<Produto> getById(@PathVariable Long id){

		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	//Rastreando os valores pelo nome 
	@GetMapping("/buscarPorNome/{nomeProduto}") //Endpoint http://localhost:8080/categorias/buscarPorNome/{nomeProduto}
	public ResponseEntity<List<Produto>> getByTitle(@PathVariable String nomeProduto){

		return ResponseEntity.ok(produtoRepository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
	}

	//Adicionando valores a tabela
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}

	//Atualizando os dados da tabela a partir do ID
	@PutMapping 
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){

		return produtoRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
						.body(produtoRepository.save(produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	//Deletando valores pelo ID
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		Optional<Produto> produto = produtoRepository.findById(id);

		if(produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		produtoRepository.deleteById(id);
	}

}
