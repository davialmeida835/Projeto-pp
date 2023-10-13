package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaDeCadastroCliente extends JanelaPadrao {
	
	public JanelaDeCadastroCliente() {
		addTexto(0, 10, 550, 30, "Cadastro Do Cliente", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		setVisible(true);
	}

}
