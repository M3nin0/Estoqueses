package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import model.Observer;
import model.Parser;
import view.ConfiguracaoView;

public class ConfiguracaoController implements Observer<String> {

	private ConfiguracaoView configuracao;

	public ConfiguracaoController() throws IOException, ParseException {
		configuracao = new ConfiguracaoView();
		configuracao.registerObserver(this);

		configuracao.textPathConfig.setText(Parser.parseConfig("config/initials.json", "configPath").get("config").toString());

		configuracao.frame.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(String obj) throws Exception {
		JSONObject json_1 = new JSONObject();
		JSONObject json_2 = new JSONObject();

		json_1.put("config", obj);
		json_2.put("configPath", json_1);

		boolean result = Parser.saveConfig(json_2);

		if (result) {
			JOptionPane.showMessageDialog(configuracao.frame, "Configuração salva com sucesso");
		} else {
			JOptionPane.showMessageDialog(configuracao.frame, "Erro ao tentar salvar a configuração");
		}

	}
}
