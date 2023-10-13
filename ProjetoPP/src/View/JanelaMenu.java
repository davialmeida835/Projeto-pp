package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaMenu extends JanelaPadrao {
	
	public JanelaMenu() {
		addTexto(0, 10, 550, 30, "MENU", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		setVisible(true);
	}

}
