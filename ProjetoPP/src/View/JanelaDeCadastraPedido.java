package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaDeCadastraPedido extends JanelaPadrao{

	public JanelaDeCadastraPedido() {
		addTexto(0, 10, 550, 30, "Fazer Pedido", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		setVisible(true);
		
		}

}
