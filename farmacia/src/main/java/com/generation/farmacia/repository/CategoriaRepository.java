package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	//Método criado para encontrar uma categoria a partir da sua descrição
	public List<Categoria> findAllByDescricaoCategoriaContainingIgnoreCase(@Param("descricaoCategoria") String descricaoCategoria);

}
