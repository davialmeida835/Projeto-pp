package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaDeCadastroFornecedor extends JanelaPadrao{
	
	public JanelaDeCadastroFornecedor() {
		addTexto(0, 10, 550, 30, "Cadastro do Fornecedor", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		setVisible(true);
	}

}
