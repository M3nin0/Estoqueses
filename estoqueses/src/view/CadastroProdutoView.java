package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class CadastroProdutoView {

	public JFrame frmTelaDeCadastro = new JFrame();

	private JTextField textCodigo;
	private JTextField textField;
	private JTextField textDescricao;
	private JTextField textQuantidade;
	private JTextField textUnidade;
	private JTextField textEspecificacao;

	public static JButton btnGravar = new JButton("Gravar");
	public static JButton btnLimparCampos = new JButton("Limpar");
	public static JButton btnCadastrarCategoria = new JButton("Cadastrar categoria");
	public static JButton btnCadastrarMarca = new JButton("Cadastrar marca");
	private JTextField textPreco;

	/**
	 * Cria os parâmetros da aplicação
	 */
	public CadastroProdutoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmTelaDeCadastro.setTitle("Tela de cadastro");
		frmTelaDeCadastro.setBounds(100, 100, 661, 499);
		frmTelaDeCadastro.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmTelaDeCadastro.getContentPane().setLayout(null);

		btnGravar.setBounds(25, 12, 91, 37);
		frmTelaDeCadastro.getContentPane().add(btnGravar);

		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimparCampos.setBounds(111, 12, 91, 37);
		frmTelaDeCadastro.getContentPane().add(btnLimparCampos);

		btnCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarCategoria.setBounds(291, 12, 183, 37);
		frmTelaDeCadastro.getContentPane().add(btnCadastrarCategoria);

		btnCadastrarMarca.setBounds(474, 12, 173, 37);
		frmTelaDeCadastro.getContentPane().add(btnCadastrarMarca);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCdigo.setBounds(38, 84, 70, 15);
		frmTelaDeCadastro.getContentPane().add(lblCdigo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(133, 84, 70, 15);
		frmTelaDeCadastro.getContentPane().add(lblNome);

		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setFont(new Font("Dialog", Font.PLAIN, 13));
		textCodigo.setBounds(36, 111, 59, 32);
		frmTelaDeCadastro.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 13));
		textField.setBounds(133, 111, 320, 32);
		frmTelaDeCadastro.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDescrio.setBounds(38, 172, 78, 15);
		frmTelaDeCadastro.getContentPane().add(lblDescrio);

		textDescricao = new JTextField();
		textDescricao.setFont(new Font("Dialog", Font.PLAIN, 13));
		textDescricao.setColumns(10);
		textDescricao.setBounds(38, 199, 320, 32);
		frmTelaDeCadastro.getContentPane().add(textDescricao);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQuantidade.setBounds(423, 172, 91, 15);
		frmTelaDeCadastro.getContentPane().add(lblQuantidade);

		textQuantidade = new JTextField();
		textQuantidade.setFont(new Font("Dialog", Font.PLAIN, 13));
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(443, 199, 59, 32);
		frmTelaDeCadastro.getContentPane().add(textQuantidade);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUnidade.setBounds(550, 172, 70, 15);
		frmTelaDeCadastro.getContentPane().add(lblUnidade);

		textUnidade = new JTextField();
		textUnidade.setFont(new Font("Dialog", Font.PLAIN, 13));
		textUnidade.setColumns(10);
		textUnidade.setBounds(550, 199, 59, 32);
		frmTelaDeCadastro.getContentPane().add(textUnidade);

		JLabel lblEspecificao = new JLabel("Especificação");
		lblEspecificao.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEspecificao.setBounds(38, 243, 107, 15);
		frmTelaDeCadastro.getContentPane().add(lblEspecificao);

		textEspecificacao = new JTextField();
		textEspecificacao.setFont(new Font("Dialog", Font.PLAIN, 13));
		textEspecificacao.setColumns(10);
		textEspecificacao.setBounds(38, 266, 320, 32);
		frmTelaDeCadastro.getContentPane().add(textEspecificacao);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMarca.setBounds(38, 310, 107, 15);
		frmTelaDeCadastro.getContentPane().add(lblMarca);

		JList listMarcas = new JList();
		listMarcas.setBounds(38, 337, 124, 37);
		frmTelaDeCadastro.getContentPane().add(listMarcas);

		JList listCategoria = new JList();
		listCategoria.setBounds(38, 419, 124, 37);
		frmTelaDeCadastro.getContentPane().add(listCategoria);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCategoria.setBounds(38, 386, 107, 15);
		frmTelaDeCadastro.getContentPane().add(lblCategoria);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPreo.setBounds(556, 243, 91, 15);
		frmTelaDeCadastro.getContentPane().add(lblPreo);
		
		textPreco = new JTextField();
		textPreco.setFont(new Font("Dialog", Font.PLAIN, 13));
		textPreco.setColumns(10);
		textPreco.setBounds(550, 266, 59, 32);
		frmTelaDeCadastro.getContentPane().add(textPreco);
	}

	public void addLister(ActionListener listener) {
		this.btnGravar.addActionListener(listener);
		this.btnLimparCampos.addActionListener(listener);
		this.btnCadastrarCategoria.addActionListener(listener);
		this.btnCadastrarMarca.addActionListener(listener);
	}
}
