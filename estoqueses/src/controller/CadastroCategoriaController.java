package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.json.simple.parser.ParseException;

import model.Categoria;
import model.ModelDAO;
import model.Observer;
import view.CadastroCategoriaView;

public class CadastroCategoriaController implements Observer<Categoria> {

	private Connection conn = null;
	private CadastroCategoriaView cadastro;

	public CadastroCategoriaController() throws SQLException, IOException, ParseException {
		cadastro = new CadastroCategoriaView();
		conn = new ModelDAO().init().getConnection();
		
		cadastro.registerObserver(this);

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
