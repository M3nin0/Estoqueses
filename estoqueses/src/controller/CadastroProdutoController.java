package controller;

import model.CadastroListener;
import view.CadastroProdutoView;

public class CadastroProdutoController {
	public CadastroProdutoController() {
		CadastroProdutoView cadastro = new CadastroProdutoView();
		cadastro.addLister(new CadastroListener());
		
		cadastro.frmTelaDeCadastro.setVisible(true);
	}
}
