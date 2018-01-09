package controller;

import model.MenuListener;
import view.MenuView;

public class MenuController {
	public MenuController() {
		MenuView menu = new MenuView();
		menu.addLister(new MenuListener());

		menu.frmControleDeEstoque.setVisible(true);
	}
}