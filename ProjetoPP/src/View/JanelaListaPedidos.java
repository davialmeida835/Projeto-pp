package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaListaPedidos extends JanelaPadrao{

	public JanelaListaPedidos() {
		addTexto(0, 10, 550, 30, "Lista de Pedidos", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		addBotaoDeVoltar();
		setVisible(true);
	}

}
