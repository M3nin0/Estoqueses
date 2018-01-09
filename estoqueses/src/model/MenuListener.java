package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.MenuView;

public class MenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuView.mntmCategoria) {
			JOptionPane.showMessageDialog(null, "Cadastro de categoria");
		} else if (e.getSource() == MenuView.mntmEstatistica) {
			JOptionPane.showMessageDialog(null, "Ver estatisticas");
		} else if (e.getSource() == MenuView.mntmMarca) {
			JOptionPane.showMessageDialog(null, "Cadastro de marcas");
		} else if (e.getSource() == MenuView.mntmVerEstoque) {
			JOptionPane.showMessageDialog(null, "Ver estoque");
		} else if (e.getSource() == MenuView.mntmProduto) {
			JOptionPane.showMessageDialog(null, "Cadastrar produto");
		}

	}

}
