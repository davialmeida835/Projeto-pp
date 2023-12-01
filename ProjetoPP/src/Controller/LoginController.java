package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.CentralDeInformacoes;
import View.JanelaDeLogin;
import View.JanelaDeMenu;

public class LoginController implements ActionListener {

	private JanelaDeLogin janelaDeLogin;

	public LoginController(JanelaDeLogin janelaDeLogin) {
		this.janelaDeLogin = janelaDeLogin;
	}

	//verifica se as informações estão corretas para poder acessar a conta
	public void actionPerformed(ActionEvent e) {

		CentralDeInformacoes c = Persistencia.recuperarCentral("central");

		String senha = new String(janelaDeLogin.getCampoDaSenha().getPassword());
		
		if (!c.getUsuario().getEmail().equals(janelaDeLogin.getCampoDoEmail().getText()) || !c.getUsuario().getSenha().equals(senha)) {
			JOptionPane.showMessageDialog(janelaDeLogin, "Digite email e senha válidos!");
		} else {
			new JanelaDeMenu();
			janelaDeLogin.dispose();
		}
	}

}
