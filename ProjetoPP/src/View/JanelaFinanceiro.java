package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaFinanceiro extends JanelaPadrao{
	
	public JanelaFinanceiro() {
		addTexto(0, 10, 550, 30, "Verifique Relatorio Mensal", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(0, 30, 550, 30,  "Verifique Pagamentos",new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
	 
		setVisible(true);
	}

}
