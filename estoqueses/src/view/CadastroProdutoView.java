package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Categoria;
import model.Marca;
import model.Observable;
import model.Observer;
import model.Produto;

public class CadastroProdutoView implements Observable<Produto> {

	public JFrame frmTelaDeCadastro = new JFrame();
	public JTextField textName;
	public JTextField textDescricao;
	public JTextField textQuantidade;
	public JTextField textUnidade;
	public JTextField textEspecificacao;
	public JTextField textPreco;

	private JList<Marca> listMarcas;
	private JList<Categoria> listCategoria;

	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimparCampos = new JButton("Limpar");
	private JButton btnCadastrarCategoria = new JButton("Cadastrar categoria");
	private JButton btnCadastrarMarca = new JButton("Cadastrar marca");

	private List<Observer<Produto>> observers;

	/**
	 * Cria os parâmetros da aplicação
	 */
	public CadastroProdutoView() {

		observers = new ArrayList<>();

		initialize();
	}

	private void initialize() {

		frmTelaDeCadastro.setTitle("Tela de cadastro");
		frmTelaDeCadastro.setBounds(100, 100, 661, 508);
		frmTelaDeCadastro.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmTelaDeCadastro.getContentPane().setLayout(null);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateProduto();
			}
		});

		btnGravar.setBounds(25, 12, 91, 37);
		frmTelaDeCadastro.getContentPane().add(btnGravar);

		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDescricao.setText("");
				textEspecificacao.setText("");
				textName.setText("");
				textPreco.setText("");
				textQuantidade.setText("");
				textUnidade.setText("");

			}
		});
		btnLimparCampos.setBounds(111, 12, 91, 37);
		frmTelaDeCadastro.getContentPane().add(btnLimparCampos);

		btnCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarCategoria.setBounds(291, 12, 178, 37);
		frmTelaDeCadastro.getContentPane().add(btnCadastrarCategoria);

		btnCadastrarMarca.setBounds(469, 12, 178, 37);
		frmTelaDeCadastro.getContentPane().add(btnCadastrarMarca);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(38, 101, 70, 15);
		frmTelaDeCadastro.getContentPane().add(lblNome);

		textName = new JTextField();
		textName.setFont(new Font("Dialog", Font.PLAIN, 13));
		textName.setBounds(38, 128, 320, 32);
		frmTelaDeCadastro.getContentPane().add(textName);
		textName.setColumns(10);

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
		lblQuantidade.setBounds(423, 101, 91, 15);
		frmTelaDeCadastro.getContentPane().add(lblQuantidade);

		textQuantidade = new JTextField();
		textQuantidade.addKeyListener(new KeyAdapter() {
			// Evita que valores não númericos, não sejam aceitos
			@Override
			public void keyTyped(KeyEvent arg0) {
				char varChar = arg0.getKeyChar();

				if (!(Character.isDigit(varChar)) || (varChar == KeyEvent.VK_BACK_SPACE)
						|| (varChar == KeyEvent.VK_DELETE)) {
					arg0.consume();
				}

			}
		});
		textQuantidade.setFont(new Font("Dialog", Font.PLAIN, 13));
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(443, 128, 59, 32);
		frmTelaDeCadastro.getContentPane().add(textQuantidade);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUnidade.setBounds(550, 101, 70, 15);
		frmTelaDeCadastro.getContentPane().add(lblUnidade);

		textUnidade = new JTextField();
		textUnidade.setFont(new Font("Dialog", Font.PLAIN, 13));
		textUnidade.setColumns(10);
		textUnidade.setBounds(550, 128, 59, 32);
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

		listMarcas = new JList<>();
		listMarcas.setBounds(38, 337, 124, 37);
		frmTelaDeCadastro.getContentPane().add(listMarcas);

		listCategoria = new JList<>();
		listCategoria.setBounds(38, 419, 124, 37);
		frmTelaDeCadastro.getContentPane().add(listCategoria);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCategoria.setBounds(38, 386, 107, 15);
		frmTelaDeCadastro.getContentPane().add(lblCategoria);

		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPreo.setBounds(556, 172, 91, 15);
		frmTelaDeCadastro.getContentPane().add(lblPreo);

		textPreco = new JTextField();
		textPreco.setFont(new Font("Dialog", Font.PLAIN, 13));
		textPreco.setColumns(10);
		textPreco.setBounds(550, 195, 59, 32);
		frmTelaDeCadastro.getContentPane().add(textPreco);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmTelaDeCadastro.setVisible(false);
			}
		});
		btnSair.setBounds(550, 419, 91, 37);
		frmTelaDeCadastro.getContentPane().add(btnSair);
	}

	public void validateProduto() {

		String descricao = null;
		String especificacao = null;
		String name = null;
		Double preco = null;
		Integer quantidade = null;
		String unidade = null;

		String[] camposInvalidos = new String[10];
		int cont = 0;

		if (!textDescricao.getText().trim().isEmpty()) {
			descricao = textDescricao.getText();
		} else {
			camposInvalidos[cont] = "Descrição precisa ser preenchido";
			cont++;
		}

		if (!textEspecificacao.getText().trim().isEmpty()) {
			especificacao = textEspecificacao.getText();
		} else {
			camposInvalidos[cont] = "O campo Especificação precisa ser preenchido";
			cont++;
		}

		if (!textName.getText().trim().isEmpty()) {
			name = textName.getText();
		} else {
			camposInvalidos[cont] = "O campo Nome precisa ser preenchido";
			cont++;
		}

		if (!textPreco.getText().trim().isEmpty()) {
			preco = Double.parseDouble(textPreco.getText());
		} else {
			camposInvalidos[cont] = "O campo Nome precisa ser preenchido";
			cont++;
		}

		if (!textQuantidade.getText().trim().isEmpty()) {
			quantidade = Integer.parseInt(textQuantidade.getText());
		} else {
			camposInvalidos[cont] = "O campo Quantidade precisa ser preenchido";
			cont++;
		}

		if (!textUnidade.getText().trim().isEmpty()) {
			unidade = textUnidade.getText();
		} else {
			camposInvalidos[cont] = "O campo Unidade precisa ser preencido!";
			cont++;
		}

		if (cont != 0) {
			String error = "Os seguintes campos precisam ser preenchidos: \n";

			for (int i = 0; i < cont; i++) {
				error += "* " + camposInvalidos[i] + "\n";
			}

			JOptionPane.showMessageDialog(null, error);

		} else {
			notifyObservers(new Produto(name, descricao, especificacao, quantidade, unidade, preco));
		}

		/*
		 * ToDo Criar verificação para marca e para categoria
		 */

	}

	@Override
	public void registerObserver(Observer<Produto> observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer<Produto> observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(Produto obj) {
		for (Observer<Produto> observer : observers) {
			try {
				observer.update(obj);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro na comunicação\n" + e);
			}
		}
	}
}
