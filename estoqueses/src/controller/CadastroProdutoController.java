package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ModelDAO;
import model.Observer;
import model.Produto;
import view.CadastroProdutoView;

public class CadastroProdutoController implements Observer<Produto> {

	private Connection conn = null;
	private CadastroProdutoView cadastro;
	
	public CadastroProdutoController() throws SQLException {
		conn = new ModelDAO().init().getConnection();
		cadastro = new CadastroProdutoView();
		cadastro.registerObserver(this);
		
		cadastro.frmTelaDeCadastro.setVisible(true);
	}

	@Override
	public void update(Produto obj) throws SQLException {

		String query = "INSERT INTO db_prods.produtos (nome, descricao, especificacao, marca, categoria, quantidade, unidade, preco) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(query);

		stmt.setString(1, obj.getNome());
		stmt.setString(2, obj.getDescricao());
		stmt.setString(3, obj.getEspecificacao());
		stmt.setString(4, "Marca");
		stmt.setString(5, "Categoria");
		stmt.setInt(6, obj.getQuantidade());
		stmt.setString(7, obj.getUnidade());
		stmt.setDouble(8, obj.getPreco());

		stmt.executeUpdate();
	}
}
