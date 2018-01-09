package model;

import java.util.LinkedList;
import java.util.List;

public class Estoque {
	private List<Produto> produtos;

	public Estoque() {
		produtos = new LinkedList<>();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
