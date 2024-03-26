package com.generation.farmacia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	//ID 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//Nome do produto
	@NotNull(message = "O atributo nomeProduto é obrigatório!") //Não pode estar vazio
	@Size(min = 5, max = 50, message = "O atributo nomeProduto deve conter de 05 à 50 caracteres")
	private String nomeProduto;

	//Descrição do produto
	@NotNull(message = "O atributo descricaoProduto é obrigatório!") //Não pode estar vazio
	@Size(min = 5, max = 100, message = "O atributo descricaoProduto deve conter de 05 à 100 caracteres")
	private String descricaoProduto;

	//Estoque
	@NotNull(message = "O atributo estoque é obrigatório!")
	@Min(value = 0, message = "O estoque deve ser maior ou igual a 0!")
	private int estoque;

	//Valor unitário do produto
	@NotNull(message = "O atributo preço é obrigatório!")
	@DecimalMin(value = "0.0", message = "O preço deve ser maior ou igual a 0!")
	private BigDecimal precoProduto;

	//Data de validade 
	@NotNull(message = "A atributo dataValidade é obrigatório!")
	@Future(message = "A data de validade não pode ter se esgotado!")
	private LocalDate dataValidade;

	//Cardinalidade do relacionamento com categoria
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	//Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
