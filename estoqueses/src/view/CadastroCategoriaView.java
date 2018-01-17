package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Categoria;
import model.Observable;
import model.Observer;

public class CadastroCategoriaView implements Observable<Categoria> {

	public JFrame frame = new JFrame();
	private JTextField textNome;
	private JTextField textDescricao;

	List<Observer<Categoria>> observers;

	public CadastroCategoriaView() {
		observers = new ArrayList<>();
		initialize();
	}

	private void initialize() {

		frame.setBounds(100, 100, 532, 344);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Integer cont = 0;
				String nome = null;
				String descricao = null;
				String camposInvalidos[] = new String[2];

				if (!textNome.getText().trim().equals("")) {
					nome = textNome.getText();
				} else {
					camposInvalidos[cont] = "Nome";
					cont++;
				}

				if (!textDescricao.getText().trim().equals("")) {
					descricao = textDescricao.getText();
				} else {
					camposInvalidos[cont] = "Descrição";
					cont++;
				}

				if (cont != 0) {

					String invalidos = "";

					for (int i = 0; i < cont; i++) {
						invalidos += "* O campo " + camposInvalidos[i] + " precisa ser preenchido\n";
					}

					JOptionPane.showMessageDialog(null, "Os seguintes campos precisam ser preenchidos: \n" + invalidos);

				} else {
					notifyObservers(new Categoria(nome, descricao));
				}

			}
		});
		btnCadastrar.setBounds(12, 12, 126, 37);
		frame.getContentPane().add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar campos");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNome.setText("");
				textDescricao.setText("");
			}
		});
		btnLimpar.setBounds(137, 12, 140, 37);
		frame.getContentPane().add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(382, 12, 126, 37);
		frame.getContentPane().add(btnVoltar);

		JLabel label = new JLabel("Nome");
		label.setBounds(23, 95, 70, 15);
		frame.getContentPane().add(label);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(23, 120, 195, 32);
		frame.getContentPane().add(textNome);

		JLabel label_1 = new JLabel("Descrição");
		label_1.setBounds(23, 175, 70, 15);
		frame.getContentPane().add(label_1);

		textDescricao = new JTextField();
		textDescricao.setColumns(30);
		textDescricao.setBounds(23, 202, 428, 85);
		frame.getContentPane().add(textDescricao);
	}

	@Override
	public void registerObserver(Observer<Categoria> observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer<Categoria> observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(Categoria obj) {
		for (Observer<Categoria> observer : observers) {
			try {
				observer.update(obj);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro na comunicação\n" + e);
			}
		}
	}
}
