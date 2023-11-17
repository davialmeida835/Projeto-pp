package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaDeMenu;
import View.JanelaPadrao;

public class OuvinteDoBotaoDeVoltarParaMenu implements ActionListener{

	private JanelaPadrao janelaPadrao;
	
	public OuvinteDoBotaoDeVoltarParaMenu(JanelaPadrao janelaPadrao) {
		this.janelaPadrao = janelaPadrao;
	}
	
	public void actionPerformed(ActionEvent e) {
		new JanelaDeMenu();
		janelaPadrao.dispose();
	}
	
}
