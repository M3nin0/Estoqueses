package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controller.CadastroMarcaController;
import controller.CadastroProdutoController;

public class MenuView {

	public JFrame frmControleDeEstoque;

	private JMenu mnCadastro;
	private JMenu mnEstoque;
	private JMenuBar menuBar;

	public static JMenuItem mntmProduto = new JMenuItem("Produto");
	public static JMenuItem mntmMarca = new JMenuItem("Marca");
	public static JMenuItem mntmCategoria = new JMenuItem("Categoria");
	public static JMenuItem mntmVerEstoque = new JMenuItem("Ver estoque");
	public static JMenuItem mntmEstatistica = new JMenuItem("Estatística");

	/**
	 * Inicializa a aplicação
	 */
	public MenuView() {
		initialize();
	}

	/**
	 * Inicializa a aplicação
	 */
	private void initialize() {
		frmControleDeEstoque = new JFrame();
		frmControleDeEstoque.setTitle("Controle de estoque");
		frmControleDeEstoque.setBounds(100, 100, 585, 415);
		frmControleDeEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmControleDeEstoque.getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 583, 21);
		frmControleDeEstoque.getContentPane().add(menuBar);

		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);

		JMenuItem mntmConfiguraes = new JMenuItem("Configurações");
		mntmConfiguraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnInicio.add(mntmConfiguraes);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Deseja sair ?", "Questão", JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		mnInicio.add(mntmSair);

		JMenu mnCadastro = new JMenu("Cadastrar");
		menuBar.add(mnCadastro);
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CadastroProdutoController();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao carregar o banco de dados");
				}
			}
		});
		mnCadastro.add(mntmProduto);
		mnCadastro.add(mntmMarca);
		mntmMarca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new CadastroMarcaController();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao carregar o banco de dados");
				}
			}
		});
		mnCadastro.add(mntmCategoria);

		JMenu mnEstoque = new JMenu("Estoque");
		menuBar.add(mnEstoque);
		mnEstoque.add(mntmVerEstoque);
		mnEstoque.add(mntmEstatistica);
	}
}