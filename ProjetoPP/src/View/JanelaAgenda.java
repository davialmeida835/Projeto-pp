package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaAgenda extends JanelaPadrao{
	
	public JanelaAgenda() {
		addTexto(0, 10, 550, 30, "Agenda Do Dia", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(0, 30, 550, 30,  "Verificar Agenda",new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
	 
		setVisible(true);
	}
	public static void main(String[] args) {
		JanelaAgenda j =  new JanelaAgenda();
	}
}
