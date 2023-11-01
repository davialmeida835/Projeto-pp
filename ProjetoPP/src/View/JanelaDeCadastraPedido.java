package View;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Util.Util;

public class JanelaDeCadastraPedido extends JanelaPadrao{

	public JanelaDeCadastraPedido() {
		addTexto(0, 10, 550, 30, "Fazer Pedido", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		addTexto(0, 30, 550, 30,  "Monte seu Pedido",new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		String[] opcoes = {"Opção 1", "Opção 2", "Opção 3", "Opção 4"};
		addComboBox(70,100,100,30,opcoes );
		addTexto(70,70,200,20,"Tipo de Roupa:");
		addTexto(70,140,150,20,"Tipo de costura:");
		addComboBox(70,170,100,30,opcoes );
		addTexto(70,210,150,20,"Tipo de Tecido:");
		addComboBox(70,240,100,30,opcoes );
		addBotaoDeVoltar();
		addB();
		addTexto(300,70,150,20,"Data de Entrega:");
		addCheckBox();
		
		adicionarCampoDaDataDeNascimento();
		setVisible(true);
		
		}
	
	private void adicionarCampoDaDataDeNascimento() {
		
		JFormattedTextField campoDoNatalicio;
		try {
			MaskFormatter mf = new MaskFormatter("##/##/####");
			campoDoNatalicio = new JFormattedTextField(mf);
			campoDoNatalicio.setBorder(new LineBorder(Color.BLACK, 1));
			campoDoNatalicio.setFont(Util.FONTE_PADRAO);
			campoDoNatalicio.setHorizontalAlignment(JTextField.CENTER);
			campoDoNatalicio.setBounds(300, 100, 130, 25);
			add(campoDoNatalicio);
		} catch (ParseException e) {}

	}
	private void addCheckBox() {
			JCheckBox checkBox = new JCheckBox("Reajustes");
			checkBox.setBounds(300, 240, 100, 30);
			add(checkBox);
 	
	}
	private void addB() {
		JButton botao = new JButton("Salvar");
		botao.setBounds(150, 400, 100, 30);
		botao.setForeground(Color.BLACK);
		botao.setBackground(Color.WHITE);
		add(botao);
		
		JButton botao1 = new JButton("Cancelar");
		botao1.setBounds(300, 400, 100, 30);
		botao1.setForeground(Color.BLACK);
		botao1.setBackground(Color.WHITE);
		add(botao1);
	
	}

}
