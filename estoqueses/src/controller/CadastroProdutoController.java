package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CadastroListener;
import model.ModelDAO;
import view.CadastroProdutoView;

public class CadastroProdutoController {

	private CadastroProdutoView cadastro;
	private ModelDAO dao;

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public CadastroProdutoController() throws SQLException {
		cadastro = new CadastroProdutoView();

		cadastro.addLister(new CadastroListener(this));

		dao = new ModelDAO();
		conn = dao.init().getConnection();
	}

	private void updateCode() {
		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT LAST_INSERT_ID() FROM produtos;");

			if (rs.next()) {
				cadastro.textCodigo.setText(rs.getString(1));
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void config() {
		updateCode();
		cadastro.frmTelaDeCadastro.setVisible(true);
	}

	public void cadastro() {
		
	}

}
