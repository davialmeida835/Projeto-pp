package Controller;

import Model.CentralDeInformacoes;
import View.JanelaDeCadastroUsuario;
import View.JanelaDeLogin;
import View.JanelaListaPedidos;

public class Main {
	public static void main(String[] args) {
		
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		if (central.getUsuario() == null) {
			JanelaDeCadastroUsuario jde = new JanelaDeCadastroUsuario();
		}
		else {
			JanelaDeLogin jdl = new JanelaDeLogin();
		}
	
		
	
	}


}
