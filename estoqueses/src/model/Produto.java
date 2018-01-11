package model;

public class Produto {
	private String nome;
	private String descricao;
	private String especificacao;
	private String marca;
	private String categoria;
	private Integer quantidade;
	private String unidade;
	private Double preco;

	public Produto(String nome, String descricao, String especificacao, Integer quantidade, String unidade,
			Double preco) {

		this.nome = nome;
		this.descricao = descricao;
		this.especificacao = especificacao;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.preco = preco;
	}

	public Produto(String nome, String descricao, String especificacao, String marca, String categoria,
			Integer quantidade, String unidade, Double preco) {

		this.nome = nome;
		this.descricao = descricao;
		this.especificacao = especificacao;
		this.marca = marca;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public String getMarca() {
		return marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public Double getPreco() {
		return preco;
	}

}