package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Categoria;
import model.ModelDAO;
import model.Observer;
import view.CadastroCategoriaView;

public class CadastroCategoriaController implements Observer<Categoria> {

	private Connection conn = null;
	private CadastroCategoriaView cadastro;

	public CadastroCategoriaController() throws SQLException {
		cadastro = new CadastroCategoriaView();
		conn = new ModelDAO().init().getConnection();

		cadastro.frame.setVisible(true);
	}

	@Override
	public void update(Categoria novaCategoria) throws Exception {
		String query = "INSERT INTO db_prods.categoria (nome, descricao) " + "VALUES (?, ?);";

		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, novaCategoria.getCategoria());
		stmt.setString(2, novaCategoria.getDescricao());

		JOptionPane.showMessageDialog(cadastro.frame, "Cadastro feito com sucesso!");
	}

}
