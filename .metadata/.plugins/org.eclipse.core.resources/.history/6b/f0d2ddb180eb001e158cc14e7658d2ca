package com.generation.farmacia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity //Entidade JPA
@Table(name = "tb_categorias") //Nome da tabela no banco de dados
public class Categoria {
	
	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Nome da categoria
	@NotNull(message = "O atributo nomeCategoria é obrigatório!") //Não pode estar vazio
	@Size(min = 5, max = 50, message = "O atributo nomeCategoria deve conter de 05 à 50 caracteres")
	private String nomeCategoria;
	
	//Descrição da categoria
	@NotNull(message = "O atributo descricaoCategoria é obrigatório!") //Não pode estar vazio
	@Size(min = 5, max = 100, message = "O atributo descricaoCategoria deve conter de 05 à 100 caracteres")
	private String descricaoCategoria;

	//Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	
}
