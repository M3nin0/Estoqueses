package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
		mnCadastro.add(mntmProduto);
		mnCadastro.add(mntmMarca);
		mnCadastro.add(mntmCategoria);

		JMenu mnEstoque = new JMenu("Estoque");
		menuBar.add(mnEstoque);
		mnEstoque.add(mntmVerEstoque);
		mnEstoque.add(mntmEstatistica);
	}

	public void addLister(ActionListener listener) {
		this.mntmProduto.addActionListener(listener);
		this.mntmCategoria.addActionListener(listener);
		this.mntmEstatistica.addActionListener(listener);
		this.mntmMarca.addActionListener(listener);
		this.mntmVerEstoque.addActionListener(listener);
	}
}