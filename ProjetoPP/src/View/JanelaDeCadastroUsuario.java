package View;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Controller.OuvinteCadastrarUsuario;
import Controller.OuvinteTirarTextoDeTextField;
import Util.Util;

public class JanelaDeCadastroUsuario extends JanelaPadrao {

	private JTextField campoDeEmail;
	private JPasswordField campoDaSenha;
	private JTextField campoDoNome;
	private JFormattedTextField campoDoTelefone;
	private JFormattedTextField campoDoNatalicio;
	
	public JanelaDeCadastroUsuario() {
		addTexto(0, 10, 550, 30, "Bem-Vindo(a) ao", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		addTexto(0, 30, 550, 30, "Cadastro do Usuário!", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);

		addTexto(125, 160, 65, 20, "E-mail:");
		addTexto(125, 215, 65, 20, "Senha:");
		addTexto(125, 270, 65, 20, "Nome:");
		addTexto(125, 325, 75, 20, "Telefone:");
		addTexto(295, 325, 75, 20, "Natalício:");
		campoDeEmail = addCampoDeTexto(125, 185, 300, 25, new LineBorder(Color.BLACK, 1), "Digite seu e-mail"); 
		campoDoNome = addCampoDeTexto(125, 295, 300, 25, new LineBorder(Color.BLACK, 1), "Digite seu nome completo"); 
		addBotao(220, 400, 110, 30, "Cadastrar", new OuvinteCadastrarUsuario(this));
		adicionarCampoDoTelefone();
		adicionarCampoDeSenha();
		adicionarCampoDaDataDeNascimento();
		addIconeTelaCadastroELogin();
		setVisible(true);
	}
	
	public JFormattedTextField getCampoDoNatalicio() {
		return campoDoNatalicio;
	}

	public JTextField getCampoDeEmail() {
		return campoDeEmail;
	}

	public JPasswordField getCampoDaSenha() {
		return campoDaSenha;
	}

	public JTextField getCampoDoNome() {
		return campoDoNome;
	}

	public JTextField getCampoDoTelefone() {
		return campoDoTelefone;
	}

	private void adicionarCampoDeSenha() {
		campoDaSenha = new JPasswordField();
		campoDaSenha.setEchoChar((char) 0);
		campoDaSenha.setFont(Util.FONTE_PADRAO);
		campoDaSenha.setText("Digite sua senha");
		campoDaSenha.addFocusListener(new OuvinteTirarTextoDeTextField("Digite sua senha"));
		campoDaSenha.setBorder(new LineBorder(Color.BLACK, 1));
		campoDaSenha.setBounds(125, 240, 300, 25);
		add(campoDaSenha);
	}

	private void adicionarCampoDoTelefone() {
		try {
			MaskFormatter mf = new MaskFormatter("(##) #####-####");
			campoDoTelefone = new JFormattedTextField(mf);
			campoDoTelefone.setBorder(new LineBorder(Color.BLACK, 1));
			campoDoTelefone.setFont(Util.FONTE_PADRAO);
			campoDoTelefone.setHorizontalAlignment(JTextField.CENTER);
			campoDoTelefone.setBounds(125, 350, 130, 25);
			add(campoDoTelefone);
		} catch (ParseException e) {}

	}
	
	private void adicionarCampoDaDataDeNascimento() {
		try {
			MaskFormatter mf = new MaskFormatter("##/##/####");
			campoDoNatalicio = new JFormattedTextField(mf);
			campoDoNatalicio.setBorder(new LineBorder(Color.BLACK, 1));
			campoDoNatalicio.setFont(Util.FONTE_PADRAO);
			campoDoNatalicio.setHorizontalAlignment(JTextField.CENTER);
			campoDoNatalicio.setBounds(295, 350, 130, 25);
			add(campoDoNatalicio);
		} catch (ParseException e) {}

	}

}
