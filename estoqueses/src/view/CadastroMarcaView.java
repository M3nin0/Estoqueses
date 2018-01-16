package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Marca;
import model.Observable;
import model.Observer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroMarcaView implements Observable<Marca> {

	public JFrame frame = new JFrame();
	private JTextField textNome;
	private JTextField textDescricao;

	private List<Observer<Marca>> observers;

	public CadastroMarcaView() {
		observers = new ArrayList<>();
		initialize();
	}

	private void initialize() {

		frame.setBounds(100, 100, 532, 344);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notifyObservers(new Marca(textNome.getText(), textNome.getText()));
			}
		});
		btnCadastro.setBounds(12, 12, 126, 37);
		frame.getContentPane().add(btnCadastro);

		JButton btnLimpar = new JButton("Limpar campos");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setBounds(137, 12, 140, 37);
		frame.getContentPane().add(btnLimpar);

		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnSair.setBounds(382, 12, 126, 37);
		frame.getContentPane().add(btnSair);

		JLabel label = new JLabel("Nome");
		label.setBounds(31, 102, 70, 15);
		frame.getContentPane().add(label);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(31, 127, 195, 32);
		frame.getContentPane().add(textNome);

		JLabel label_1 = new JLabel("Descrição");
		label_1.setBounds(31, 182, 70, 15);
		frame.getContentPane().add(label_1);

		textDescricao = new JTextField();
		textDescricao.setColumns(30);
		textDescricao.setBounds(31, 209, 428, 85);
		frame.getContentPane().add(textDescricao);
	}

	@Override
	public void registerObserver(Observer<Marca> observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer<Marca> observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers(Marca obj) {
		for (Observer<Marca> observer: observers) {
			try {
				observer.update(obj);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro na comunicação\n" + e);
			}
		}

	}

}
