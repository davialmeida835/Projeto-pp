package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JanelaAdicionarMaterias extends JanelaPadrao{

	public static void main(String[] args) {
		new JanelaAdicionarMaterias();
	}
	
	public JanelaAdicionarMaterias() {
		addTexto(105, 120, 190, 20, "Nome:");
		addTexto(0, 30, 550, 30, "Adicionar Material", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		addTexto(105, 205, 65, 20, "Tipo:");
		addTexto(105, 260, 65, 20, "Tamanho:");
		addTexto(105, 315, 180, 20, "Preço por tamanho(m):");
		addBotaoDeVoltar();
		setVisible(true);
	}
}
