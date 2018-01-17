package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Observable;
import model.Observer;

public class ConfiguracaoView implements Observable<String> {

	public JFrame frame;
	public JTextField textPathConfig = new JTextField();;
	private JFileChooser fc;

	List<Observer<String>> observers;

	public ConfiguracaoView() {
		observers = new ArrayList<>();
		fc = new JFileChooser();

		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 532, 264);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnSalvar = new JButton("Salvar alteração");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				notifyObservers(textPathConfig.getText().toString());
			}
		});
		btnSalvar.setBounds(12, 12, 156, 37);
		frame.getContentPane().add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(382, 12, 126, 37);
		frame.getContentPane().add(btnVoltar);

		JLabel lblArquivoDeConfigurao = new JLabel("Arquivo de configuração do banco de dados");
		lblArquivoDeConfigurao.setBounds(26, 115, 321, 15);
		frame.getContentPane().add(lblArquivoDeConfigurao);

		textPathConfig.setColumns(10);
		textPathConfig.setBounds(26, 142, 364, 32);
		frame.getContentPane().add(textPathConfig);

		JButton btnSelectFile = new JButton("...");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer chose = fc.showOpenDialog(frame);

				if (chose == JFileChooser.APPROVE_OPTION) {
					textPathConfig.setText(fc.getSelectedFile().toString());
				}

			}
		});
		btnSelectFile.setBounds(398, 147, 29, 25);
		frame.getContentPane().add(btnSelectFile);
	}

	@Override
	public void registerObserver(Observer<String> observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer<String> observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String obj) {
		for (Observer<String> observer : observers) {
			try {
				observer.update(obj);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar recuperar o arquivo\n" + e);
			}
		}
	}
}
