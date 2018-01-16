package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Marca;
import model.ModelDAO;
import model.Observer;
import view.CadastroMarcaView;

public class CadastroMarcaController implements Observer<Marca> {

	private Connection conn = null;
	private CadastroMarcaView cadastroMarca;

	public CadastroMarcaController() throws SQLException {

		conn = new ModelDAO().init().getConnection();

		cadastroMarca = new CadastroMarcaView();
		cadastroMarca.registerObserver(this);

		cadastroMarca.frame.setVisible(true);
	}

	@Override
	public void update(Marca marca) throws Exception {
		String query = "INSERT INTO db_prods.marca (nome, descricao) " 
				+ "VALUES (?, ?)";

		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, marca.getMarca());
		stmt.setString(2, marca.getDescricao());
		
		stmt.executeUpdate();
		
		JOptionPane.showMessageDialog(cadastroMarca.frame, "Cadastro feito com sucesso");
		
	}
}
