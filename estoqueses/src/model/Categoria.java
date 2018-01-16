package model;

public class Categoria {
	private Integer codigo;
	private String categoria;
	private String descricao;

	public Categoria(String categoria, String descricao) {
		this.categoria = categoria;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return this.categoria;
	}

}
