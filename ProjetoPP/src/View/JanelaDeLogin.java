package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.LoginController;
import Controller.OuvinteTirarTextoDeTextField;
import Controller.Persistencia;
import Model.CentralDeInformacoes;

public class JanelaDeLogin extends JanelaPadrao {

	private JTextField campoDoEmail;
	private JPasswordField campoDaSenha;

	public JTextField getCampoDoEmail() {
		return campoDoEmail;
	}
	
	public JPasswordField getCampoDaSenha() {
		return campoDaSenha;
	}
	
	public JanelaDeLogin() {
		CentralDeInformacoes central = Persistencia.recuperarCentral("central");
		addTexto(125, 180, 65, 20, "E-mail:");
		addTexto(125, 235, 65, 20, "Senha:");
		String primeiroNome = central.getUsuario().getNome().split(" ")[0];
		
		addTexto(0, 10, 550, 30, "Bem-Vindo(a) de volta " + primeiroNome + "!", new Font("Arial", Font.BOLD, 17), JLabel.CENTER,
				Color.BLACK);
		
		
		campoDoEmail = addCampoDeTexto(125, 205, 300, 25, new LineBorder(Color.BLACK, 1), "Digite seu e-mail"); 

		adicionarCampoDeSenha();
		
		addBotao(220, 350, 110, 30, "Entrar", new LoginController(this));
		addIconeTelaCadastroELogin();
		addWallpaper();
		setVisible(true);
	}

	private void adicionarCampoDeSenha() {
		campoDaSenha = new JPasswordField();
		campoDaSenha.setEchoChar((char) 0);
		campoDaSenha.setFont(Model.Util.FONTE_PADRAO);
		campoDaSenha.setText("Digite sua senha");
		campoDaSenha.addFocusListener(new OuvinteTirarTextoDeTextField("Digite sua senha"));
		campoDaSenha.setBorder(new LineBorder(Color.BLACK, 1));
		campoDaSenha.setBounds(125, 260, 300, 25);
		add(campoDaSenha);
	}
	
}
