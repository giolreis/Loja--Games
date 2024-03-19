package com.generation.gamestore.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "tb_produtos")
public class Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "O atributo nome é obrigatório!") 
	@Size(min = 5, max = 75, message = "O atributo nome deve conter de 05-75 caracteres")
	private String nome;
	
	
	@NotBlank(message = "O atributo descrição é obrigatório!") 
	@Size(min = 5, max = 1000, message = "O atributo descrição deve conter de 05-100 caracteres") 
	private String descricao;
	
	
	@NotNull(message = "O atributo preço é obrigatório!") 
	@DecimalMin(value = "0.0", message = "O preço deve ser maior ou igual a 0.0")
	private BigDecimal preco;
	
	
	@NotNull(message = "O atributo estoque é obrigatório!")
	@Min(value = 0, message = "O estoque deve ser maior ou igual a 0")
	private Integer estoque;
	

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
