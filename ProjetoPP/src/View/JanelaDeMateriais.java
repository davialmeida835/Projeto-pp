package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaDeMateriais extends JanelaPadrao{
	
	public JanelaDeMateriais() {
		addTexto(0, 10, 550, 30, "Adicionar Materiais", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		
		setVisible(true);

	}

	

}
